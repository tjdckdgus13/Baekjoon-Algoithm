import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] check;
    static int N, M;
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    check = new boolean[N][M];
                    result = Math.max(result, bfs(j, i));
                }
            }
        }

        System.out.println(result);
    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        check[y][x] = true;
        int count = 0;
        while (!queue.isEmpty()) {

            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {

                int moveX = node.x + X[i];
                int moveY = node.y + Y[i];

                if (moveX < 0 || moveX >= M || moveY < 0 || moveY >= N ||
                        check[moveY][moveX] || map[moveY][moveX] == 'W') continue;

                queue.add(new Node(moveX, moveY, node.num + 1));
                check[moveY][moveX] = true;
                count = Math.max(count, node.num + 1);
            }

        }

        return count;
    }

}

class Node {
    int x;
    int y;
    int num;

    public Node(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}