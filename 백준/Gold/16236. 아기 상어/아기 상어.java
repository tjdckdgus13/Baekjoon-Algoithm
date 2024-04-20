import java.io.*;
import java.util.*;

public class Main {
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};
    static int[][] map;
    static int N;
    static int sharkX, sharkY;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        sharkX = 0;
        sharkY = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 9) {
                    sharkX = j;
                    sharkY = i;
                    continue;
                }
                map[i][j] = num;
            }
        }
        bfs();

        System.out.println(result);
    }

    public static void bfs() {

        int size = 2;
        int eat = 0;
        while (true) {
            Queue<Node> queue = new LinkedList<>();
            boolean[][] check = new boolean[N][N];
            queue.add(new Node(sharkX, sharkY, 0));
            check[sharkY][sharkX] = true;

            List<Node> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int xmove = node.x + X[i];
                    int ymove = node.y + Y[i];

                    if (xmove < 0 || xmove >= N || ymove < 0 || ymove >= N || map[ymove][xmove] > size) continue;

                    if (check[ymove][xmove]) continue;

                    check[ymove][xmove] = true;
                    if (map[ymove][xmove] == 0 || map[ymove][xmove] == size) {
                        queue.add(new Node(xmove, ymove, node.count + 1));
                    } else {
                        list.add(new Node(xmove, ymove, node.count + 1));
                    }
                }

            }

            if (list.size() == 0) break;

                Collections.sort(list, (o1, o2) -> {
                    if (o1.count == o2.count) {
                        if (o1.y == o2.y) {
                            return o1.x - o2.x;

                        } else {
                            return o1.y - o2.y;
                        }
                    } else {
                        return o1.count - o2.count;
                    }
                });


            eat++;
            result += list.get(0).count;
            sharkX = list.get(0).x;
            sharkY = list.get(0).y;
            map[sharkY][sharkX] = 0;
            if (size == eat) {
                size++;
                eat = 0;
            }

        }
    }

}

class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}