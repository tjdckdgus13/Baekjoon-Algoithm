import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static ArrayList<Integer>[] list;
    static int[] students;
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        int student = N * N + 1;

        students = new int[student];
        list = new ArrayList[student];

        for (int i = 1; i < student; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());

            students[i] = parent;

            for (int j = 0; j < 4; j++) {
                list[parent].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i < student; i++) {
            bfs(students[i]);
        }

        System.out.println(count());
    }

    static void bfs(int num) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int friend = 0, empty = 0;

                if (map[i][j] != 0) continue;

                for (int k = 0; k < 4; k++) {
                    int moveX = j + X[k];
                    int moveY = i + Y[k];

                    if (check(moveX, moveY)) continue;

                    if (map[moveY][moveX] == 0) {
                        empty++;
                        continue;
                    }

                    for (int g : list[num]) {
                        if (map[moveY][moveX] == g) {
                            friend++;
                            break;
                        }
                    }
                }

                queue.add(new Node(j, i, friend, empty));
            }
        }

        Node node = queue.poll();
        map[node.y][node.x] = num;
    }

    static int count() {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;

                for (int k = 0; k < 4; k++) {
                    int moveX = j + X[k];
                    int moveY = i + Y[k];

                    if (check(moveX, moveY)) continue;

                    for (int g : list[map[i][j]]) {
                        if (g == map[moveY][moveX]) {
                            count++;
                            break;
                        }
                    }
                }

                sum += satisfaction(count);
            }
        }

        return sum;
    }

    static int satisfaction(int count) {
        if (count == 0) {
            return 0;
        } else if (count == 1) {
            return 1;
        } else if (count == 2) {
            return 10;
        } else if (count == 3) {
            return 100;
        } else {
            return 1000;
        }
    }

    static boolean check(int x, int y) {
        return x >= N || x < 0 || y >= N || y < 0;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int friend;
    int empty;

    public Node(int x, int y, int friend, int empty) {
        this.x = x;
        this.y = y;
        this.friend = friend;
        this.empty = empty;
    }

    @Override
    public int compareTo(Node o) {
        if (this.friend != o.friend) return o.friend - this.friend;
        if (this.empty != o.empty) return o.empty - this.empty;
        if (this.y != o.y) return this.y - o.y;
        return this.x - o.x;
    }
}