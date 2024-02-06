import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int count = 0;

			for (int i = N; i <= M; i++) {

				if (i == 0) {
					count++;
					continue;
				}

				int num = i;
				while (num > 0) {
					if (num % 10 == 0)
						count++;

					num /= 10;
				}
			}

			sb.append(count + "\n");
		}

		System.out.println(sb.toString());
	}

}
