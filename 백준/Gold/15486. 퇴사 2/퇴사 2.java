import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int T[] = new int[N + 1];
		int P[] = new int[N + 1];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		int dp[] = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {

			if (max < dp[i]) {
				max = dp[i];
			}

			int time = i + T[i];
			if (time < N + 1) {
				dp[time] = Math.max(dp[time], max + P[i]);
			}
		}	
		System.out.println(max);
	}
}