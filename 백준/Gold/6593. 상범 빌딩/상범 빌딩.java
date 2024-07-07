import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int L, R, C;
    static int[][][] arr;
    static boolean[][][] visit;
    static int startX, startY, startZ;
    static int[] X = {1, 0, -1, 0, 0, 0};
    static int[] Y = {0, 1, 0, -1, 0, 0};
    static int[] Z = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            arr = new int[L][R][C];
            visit = new boolean[L][R][C];
            for (int i = 0; i < L; i++) {

                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char c = str.charAt(k);
                        if (c == '.') {
                            arr[i][j][k] = 0;
                        } else if (c == '#') {
                            arr[i][j][k] = 1;
                        } else if (c == 'S') {
                            startX = k;
                            startY = j;
                            startZ = i;
                        } else {
                            arr[i][j][k] = 2;
                        }
                    }
                }

                br.readLine();
            }

            int result = bfs();

            if (result == 0) {
                sb.append("Trapped!").append("\n");
            } else {
                sb.append("Escaped in ").append(result).append(" minute(s).").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(startX, startY, startZ, 0));
        visit[startZ][startY][startX] = true;

        int result = 0;
        while (!queue.isEmpty()) {

            Node node = queue.poll();

            int x = node.x;
            int y = node.y;
            int z = node.z;

            for (int i = 0; i < 6; i++) {
                int moveX = x + X[i];
                int moveY = y + Y[i];
                int moveZ = z + Z[i];

                if (check(moveX, moveY, moveZ)) continue;

                if (arr[moveZ][moveY][moveX] == 2) {
                    result = node.count + 1;
                    break;
                }

                queue.add(new Node(moveX, moveY, moveZ, node.count + 1));
                visit[moveZ][moveY][moveX] = true;
            }
        }

        return result;
    }

    static boolean check(int x, int y, int z) {
        return x >= C || x < 0 || y >= R || y < 0 || z >= L || z < 0 || visit[z][y][x] || arr[z][y][x] == 1;
    }

}

class Node {
    int x;
    int y;
    int z;
    int count;

    public Node(int x, int y, int z, int count) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
    }
}