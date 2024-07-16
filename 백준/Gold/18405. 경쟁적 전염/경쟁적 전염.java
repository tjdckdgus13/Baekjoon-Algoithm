import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, S;
    static int[][] map;
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};
    static boolean[][] visit;
    static PriorityQueue<Node> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;

                if (a == 0) continue;

                queue.add(new Node(j, i, a));
            }
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());

        bfs();

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        System.out.println(map[y - 1][x - 1]);
    }

    static void bfs() {

        for (int i = 0; i < S; i++) {
            if (queue.isEmpty()) break;

            List<Node> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int moveX = node.x + X[j];
                    int moveY = node.y + Y[j];

                    if (check(moveX, moveY)) continue;

                    map[moveY][moveX] = node.num;
                    list.add(new Node(moveX, moveY, node.num));
                }
            }

            while (!list.isEmpty()) {
                queue.add(list.remove(0));
            }
        }
    }

    static boolean check(int x, int y) {
        return x >= N || x < 0 || y >= N || y < 0 || map[y][x] != 0;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int num;

    public Node(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }

    @Override
    public int compareTo(Node o) {
        return this.num - o.num;
    }
}