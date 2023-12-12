import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int leng = st.countTokens();

			for (int j = 0; j < leng; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N][N];

		dp[0][0] = arr[0][0];
		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][0] + arr[i][0];

			for (int j = 1; j <= i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j];
			}

			dp[i][i] = dp[i - 1][i - 1] + arr[i][i];
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(result, dp[N - 1][i]);
		}

		System.out.println(result);
	}
}
