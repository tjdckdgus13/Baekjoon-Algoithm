import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int dp[] = new int[10001];
		int coin[] = new int[100];

		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE-1;
		}

		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j - coin[i] >= 0) {
					dp[j] = Math.min(dp[j], dp[j - coin[i]]+1);
				}
			}
		}

		if(dp[k] == Integer.MAX_VALUE-1) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
		

	}
}