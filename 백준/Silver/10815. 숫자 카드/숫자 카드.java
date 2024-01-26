import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			map.put(st.nextToken(), 0);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			if (map.get(st.nextToken()) == null) {
				sb.append(0 + " ");
			} else {
				sb.append(1 + " ");
			}
		}

		System.out.println(sb.toString());
	}
}
