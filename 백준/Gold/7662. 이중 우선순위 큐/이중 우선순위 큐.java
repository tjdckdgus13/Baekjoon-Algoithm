import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static TreeMap<Integer, Integer> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			map = new TreeMap<>();

			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				String str = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (str.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
					continue;
				}

				if (map.isEmpty())
					continue;

				int n = num == 1 ? map.lastKey() : map.firstKey();
				put(n);
			}

			if (map.isEmpty()) {
				sb.append("EMPTY" + "\n");
			} else {
				sb.append(map.lastKey() + " " + map.firstKey() + "\n");
			}

		}

		System.out.println(sb.toString());
	}

	public static void put(int n) {
		if (map.get(n) > 1) {
			map.put(n, map.get(n) - 1);
		} else {
			map.remove(n);
		}
	}

}
