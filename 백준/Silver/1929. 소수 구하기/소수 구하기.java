import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean b[] = new boolean[N + 1];

		b[0] = true;
		b[1] = true;

		for (int i = 2; i < N; i++) {
			if(b[i]) continue;
			for (int j = 2; i * j <= N; j++) {
				b[i * j] = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (!b[i]) {
				sb.append(i + "\n");
			}
		}
		
		System.out.println(sb);
	}
}