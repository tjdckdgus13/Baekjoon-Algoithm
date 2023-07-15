import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int dp[];
	static int arr[];
	static int a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		a = N;
		arr = new int[N + 1];
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[i] = -1;
		}

		dp[0] = 0;
		dp[1] = arr[1];

		if (N > 1) {
			dp[2] = arr[1] + arr[2];
		}
		System.out.println(DP(N));
	}

	static int DP(int N) {

		if (dp[N] == -1) {
			dp[N] = Math.max(DP(N - 3) + arr[N - 1], DP(N - 2)) + arr[N];
		}
		return dp[N];
	}
}
