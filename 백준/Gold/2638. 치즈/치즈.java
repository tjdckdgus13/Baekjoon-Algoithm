import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count;
    static int[][] map;
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if (a == 1) count++;
            }
        }

        int time = 0;
        while (count != 0) {
            visit = new boolean[N][M];
            dfs(0,0);
            check();
            time++;
        }

        System.out.println(time);
    }

    static void dfs(int x, int y) {
        map[y][x] = 2;
        for (int i = 0; i < 4; i++) {
            int xmove = x + X[i];
            int ymove = y + Y[i];

            if (xmove < 0 || xmove >= M || ymove < 0 || ymove >= N || visit[ymove][xmove] || map[ymove][xmove] == 1)
                continue;

            visit[ymove][xmove] = true;
            dfs(xmove, ymove);
        }

    }

    static void check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 1) continue;

                int num = 0;
                for (int k = 0; k < 4; k++) {
                    int xmove = j + X[k];
                    int ymove = i + Y[k];

                    if (xmove < 0 || xmove >= M || ymove < 0 || ymove >= N || map[ymove][xmove] != 2) continue;

                    num++;
                }

                if (num >= 2) {
                    count--;
                    map[i][j] = 0;
                }
            }
        }
    }
}