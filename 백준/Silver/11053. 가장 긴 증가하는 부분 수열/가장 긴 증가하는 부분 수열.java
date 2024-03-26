import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(1);
            System.exit(0);
        }

        Arrays.fill(dp, Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            dfs(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    public static int dfs(int N) {

        if (dp[N] == Integer.MIN_VALUE) {

            dp[N] = 1;

            for (int i = N - 1; i >= 0; i--) {
                if (arr[N] > arr[i]) {
                    dp[N] = Math.max(dp[N], dfs(i) + 1);
                }
            }
        }
        return dp[N];
    }
}
