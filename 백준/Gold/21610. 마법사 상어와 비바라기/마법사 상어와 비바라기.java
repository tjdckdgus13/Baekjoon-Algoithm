import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Node> queue = new LinkedList<>();
    static int[] X = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] Y = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.add(new Node(N - 1, 0));
        queue.add(new Node(N - 1, 1));
        queue.add(new Node(N - 2, 0));
        queue.add(new Node(N - 2, 1));

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            moveCloud(d - 1, s);
            waterCopy();
            makeCloud();
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result);
    }

    static void moveCloud(int d, int s) {
        for (Node node : queue) {
            node.x = (N + node.x + X[d] * (s % N)) % N;
            node.y = (N + node.y + Y[d] * (s % N)) % N;

            map[node.y][node.x]++;
            visit[node.y][node.x] = true;
        }
    }


    static void waterCopy() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 1; i <= 7; i += 2) {
                int moveX = node.x + X[i];
                int moveY = node.y + Y[i];
                if (check(moveX, moveY) || map[moveY][moveX] <= 0) continue;

                map[node.y][node.x]++;
            }
        }
    }

    static void makeCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) {
                    visit[i][j] = false;
                    continue;
                }

                if (map[i][j] >= 2) {
                    map[i][j] -= 2;
                    queue.add(new Node(i, j));
                }

            }
        }
    }

    static boolean check(int x, int y) {
        return x >= N || x < 0 || y >= N || y < 0;
    }

}

class Node {
    int x;
    int y;

    public Node(int y, int x) {
        this.x = x;
        this.y = y;
    }
}