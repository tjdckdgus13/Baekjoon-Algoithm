import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			Test(N);
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	public static void Test(int N) throws IOException {

		Map<String, Integer> map = new HashMap<>();

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			st.nextToken();
			String body = st.nextToken();

			map.put(body, map.getOrDefault(body, 0) + 1);
		}

		int result = 1;
		for (int i : map.values()) {
			result *= (i + 1);
		}

		sb.append(result - 1);
	}

}
