import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			int len = Integer.parseInt(br.readLine());

			int[][] arr = new int[2][len + 1];
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= len; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[2][len + 1];

			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];

			for (int j = 2; j <= len; j++) {
				dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
				dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];

			}

			System.out.println(Math.max(dp[0][len], dp[1][len]));
		}
	}
}
