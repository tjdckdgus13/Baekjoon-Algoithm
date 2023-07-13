import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dp[][];
	static int price[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		price = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][3];
		dp[0][0] = price[0][0];
		dp[0][1] = price[0][1];
		dp[0][2] = price[0][2];

		System.out.println(Math.min(sum(N - 1, 0), Math.min(sum(N - 1, 1), sum(N - 1, 2))));
	}

	static int sum(int N, int c) {

		if (dp[N][c] == 0) {

			if (c == 0) {
				dp[N][0] = Math.min(sum(N - 1, 1), sum(N - 1, 2)) + price[N][0];
			} else if (c == 1) {
				dp[N][1] = Math.min(sum(N - 1, 0), sum(N - 1, 2)) + price[N][1];
			} else {
				dp[N][2] = Math.min(sum(N - 1, 0), sum(N - 1, 1)) + price[N][2];
			}

		}

		return dp[N][c];
	}
}
