import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int answer;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0, 0);

        System.out.println(answer);

    }

    public static void dfs(int x, int y, int pipe) {
        if (x == N - 1 && y == N - 1) {
            answer++;
            return;
        }

        if (pipe == 0) {
            if (x + 1 < N && y < N && arr[y][x + 1] == 0)
                dfs(x + 1, y, 0);
        } else if (pipe == 1) {
            if (y + 1 < N && arr[y + 1][x] == 0)
                dfs(x, y + 1, 1);
        } else if (pipe == 2) {
            if (x + 1 < N && arr[y][x + 1] == 0)
                dfs(x + 1, y, 0);

            if (y + 1 < N && arr[y + 1][x] == 0)
                dfs(x, y + 1, 1);
        }

        if (y + 1 < N && x + 1 < N && arr[y][x + 1] == 0 && arr[y + 1][x] == 0 && arr[y + 1][x + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }
    }
}