import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		dp = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int a = Integer.parseInt(st.nextToken());

				dp[i][j] = dp[i][j - 1] + a;

			}

		}

		StringBuilder sb = new StringBuilder();

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			int result = make(x1, y1, x2, y2);
			sb.append(result + "\n");
		}

		System.out.println(sb.toString());
	}

	public static int make(int x1, int y1, int x2, int y2) {

		int result = 0;
		for (int i = y1; i <= y2; i++) {
			result += dp[i][x2] - dp[i][x1 - 1];
		}

		return result;

	}

}
