import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visit;
	static int n, m;
	static int[] X = { 1, 0, -1, 0 };
	static int[] Y = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new boolean[n][m];
		map = new int[n][m];
		int a = 0, b = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					a = i;
					b = j;
				}
			}
		}

		bfs(a, b);
        
		map[a][b] = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					sb.append(-1 + " ");
					continue;
				}
				sb.append(map[i][j] + " ");
			}

			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void bfs(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { a, b, 0 });
		visit[a][b] = true;
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();

			for (int i = 0; i < 4; i++) {
				int moveX = arr[1] + X[i];
				int moveY = arr[0] + Y[i];

				if (moveX < 0 || moveX >= m || moveY < 0 || moveY >= n || visit[moveY][moveX]
						|| map[moveY][moveX] == 0) {
					continue;
				}

				map[moveY][moveX] = arr[2] + 1;
				visit[moveY][moveX] = true;
				queue.add(new int[] { moveY, moveX, arr[2] + 1 });
			}
		}
	}
}
