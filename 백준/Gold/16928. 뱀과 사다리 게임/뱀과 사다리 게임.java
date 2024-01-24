import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[101];

		for (int i = 1; i <= 100; i++) {
			map[i] = i;
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(1);

		int[] check = new int[101];

		while (!queue.isEmpty()) {
			int n = queue.poll();

			for (int i = 1; i < 7; i++) {
				int move = n + i;

				if (move > 100) {
					continue;
				}

				if (check[map[move]] == 0) {
					queue.add(map[move]);
					check[map[move]] = check[n] + 1;
				}

				if (map[move] == 100)
					return check[100];

			}
		}

		return check[100];
	}

}
