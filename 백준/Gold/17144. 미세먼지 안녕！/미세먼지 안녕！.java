import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};
    static int cleaner, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;

                if (n == -1) cleaner = i;
            }
        }

        while (T-- > 0) {
            dust();
            on();
        }

        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                count += arr[i][j];
            }
        }

        System.out.println(count + 2);
    }


    public static void dust() {
        int[][] sum = new int[R][C];
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (arr[y][x] == -1 || arr[y][x] == 0) continue;

                int middle = arr[y][x] / 5;
                for (int k = 0; k < 4; k++) {
                    int xmove = x + X[k];
                    int ymove = y + Y[k];

                    if (xmove < 0 || xmove >= C || ymove < 0 || ymove >= R || arr[ymove][xmove] == -1) continue;
                    sum[ymove][xmove] += middle;
                    arr[y][x] -= middle;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] += sum[i][j];
            }
        }
    }

    public static void on() {
        int up = cleaner - 1;
        int down = cleaner;

        for (int i = up - 1; i > 0; i--) {
            arr[i][0] = arr[i - 1][0];
        }

        for (int i = 0; i < C - 1; i++) {
            arr[0][i] = arr[0][i + 1];
        }

        for (int i = 0; i < up; i++) {
            arr[i][C - 1] = arr[i + 1][C - 1];
        }

        for (int i = C - 1; i > 0; i--) {
            arr[up][i] = arr[up][i - 1];
        }

        arr[up][1] = 0;

        for (int i = down + 1; i < R - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }

        for (int i = 0; i < C - 1; i++) {
            arr[R - 1][i] = arr[R - 1][i + 1];
        }

        for (int i = R - 1; i > down; i--) {
            arr[i][C - 1] = arr[i - 1][C - 1];
        }

        for (int i = C - 1; i > 1; i--) {
            arr[down][i] = arr[down][i - 1];
        }

        arr[down][1] = 0;
    }
}
