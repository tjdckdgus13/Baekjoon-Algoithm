import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			dp[i] = -1;
		}

		dp[1] = 1;
		if (N > 1) {
			dp[2] = 2;
		}

		System.out.println(DP(N));
	}

	static int DP(int N) {

		if (dp[N] == -1) {
			dp[N] = DP(N - 1) + DP(N - 2);
		}

		return dp[N] % 10007;
	}
}
