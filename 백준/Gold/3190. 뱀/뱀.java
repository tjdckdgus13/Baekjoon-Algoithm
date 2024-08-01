import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, time;
    static int[][] map;
    static Queue<alter> queue = new LinkedList<>();
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 2;
        }

        int L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();

            queue.add(new alter(X, C));
        }

        bfs();

        System.out.println(time);
    }

    static void bfs() {
        time = 0;
        int r = 1;
        int c = 1;
        int direction = 0;
        map[1][1] = 1;
        Deque<Node> snake = new ArrayDeque<>();
        snake.add(new Node(1, 1));
        while (!queue.isEmpty()) {
            alter alt = queue.poll();

            int curNum = alt.num;
            String curDirection = alt.direction;

            while (time != curNum) {
                r = r + Y[direction];
                c = c + X[direction];

                time++;

                if (r < 1 || r > N || c < 1 || c > N || map[r][c] == 1) {
                    return;
                }

                if (map[r][c] == 2) {
                    snake.addFirst(new Node(r, c));
                    map[r][c] = 1;
                } else {
                    snake.addFirst(new Node(r, c));
                    Node remove = snake.removeLast();
                    map[remove.r][remove.c] = 0;
                    map[r][c] = 1;
                }

            }

            if (curDirection.equals("L")) {
                direction = direction - 1 < 0 ? 3 : direction - 1;
            } else {
                direction = direction + 1 > 3 ? 0 : direction + 1;
            }

            if (queue.isEmpty()) {
                while (true) {
                    r = r + Y[direction];
                    c = c + X[direction];

                    time++;

                    if (r < 1 || r > N || c < 1 || c > N || map[r][c] == 1) {
                        return;
                    }

                    if (map[r][c] == 2) {
                        snake.addFirst(new Node(r, c));
                        map[r][c] = 1;
                    } else {
                        snake.addFirst(new Node(r, c));
                        Node remove = snake.removeLast();
                        map[remove.r][remove.c] = 0;
                        map[r][c] = 1;
                    }

                }
            }

        }
    }

}

class alter {
    int num;
    String direction;

    public alter(int num, String direction) {
        this.num = num;
        this.direction = direction;
    }
}

class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}