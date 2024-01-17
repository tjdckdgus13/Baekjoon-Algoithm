import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String[] str;
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
        
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			check(N);
		}

		System.out.println(sb.toString());
	}

	public static void check(int N) throws IOException {
		str = new String[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			str[i] = st.nextToken();
		}

		if (N > 32) {
			sb.append(0 + "\n");
			return;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int count = 0;
					for (int m = 0; m < 4; m++) {
						count += str[i].charAt(m) != str[j].charAt(m) ? 1 : 0;
						count += str[j].charAt(m) != str[k].charAt(m) ? 1 : 0;
						count += str[i].charAt(m) != str[k].charAt(m) ? 1 : 0;
					}

					min = Math.min(count, min);
				}
			}
		}

		sb.append(min + "\n");
	}

}
