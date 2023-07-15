import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dp = new int[10 + 1];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= 10; i++) {
			dp[i] = -1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(DP(Integer.parseInt(br.readLine())) + "\n");
		}

		System.out.println(sb.toString());

	}

	static int DP(int N) {
		if (dp[N] == -1) {
			dp[N] = DP(N - 1) + DP(N - 2) + DP(N - 3);
		}
		return dp[N];
	}
}
