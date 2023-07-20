import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<int[]> person = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	static boolean[] check;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String[] a = br.readLine().split(" ");

			for (int j = 0; j < a.length; j++) {
				if (a[j].equals("1")) {
					person.add(new int[] { i, j });
				} else if (a[j].equals("2")) {
					chicken.add(new int[] { i, j });
				}
			}
		}
		check = new boolean[chicken.size()];

		dfs(0, 0, M);

		System.out.println(result);
	}

	public static void dfs(int s, int c, int m) {
		if (c == m) {
			int all = 0;
			for (int i = 0; i < person.size(); i++) {
				int min = Integer.MAX_VALUE;
				int[] a = person.get(i);
				for (int j = 0; j < chicken.size(); j++) {
					if (check[j]) {
						int[] b = chicken.get(j);
						int distance = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);

						min = Math.min(min, distance);
					}
				}
				all += min;
			}

			result = Math.min(all, result);
			return;
		}

		for (int i = s; i < check.length; i++) {
			check[i] = true;
			dfs(i + 1, c + 1, m);
			check[i] = false;
		}
	}
}
