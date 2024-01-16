import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int N;
	static int M;
	static int[] X = { 1, 0, -1, 0 };
	static int[] Y = { 0, 1, 0, -1 };

	static int[][] X2 = { { 0, 1, 2, 1 }, { 0, 0, 0, -1 }, { 0, 1, 2, 1 }, { 0, 0, 0, 1 } };
	static int[][] Y2 = { { 0, 0, 0, 1 }, { 0, 1, 2, 1 }, { 0, 0, 0, -1 }, { 0, 1, 2, 1 } };

	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				visit[i][j] = true;

				dfs(i, j, map[i][j], 1);

				visit[i][j] = false;

				other(i, j);
			}
		}

		System.out.println(max);
	}

	static void dfs(int y, int x, int sum, int length) {
		if (length == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int xmove = x + X[i];
			int ymove = y + Y[i];

			if (xmove >= M || xmove < 0 || ymove >= N || ymove < 0 || visit[ymove][xmove]) {
				continue;
			}

			visit[ymove][xmove] = true;

			dfs(ymove, xmove, sum + map[ymove][xmove], length + 1);

			visit[ymove][xmove] = false;
		}
	}

	static void other(int y, int x) {

		for (int i = 0; i < 4; i++) {

			boolean bl = false;
			int sum = 0;

			for (int j = 0; j < 4; j++) {
				int xmove = x + X2[i][j];
				int ymove = y + Y2[i][j];

				if (xmove < 0 || xmove >= M || ymove < 0 || ymove >= N) {
					bl = true;
					break;
				}

				sum += map[ymove][xmove];
			}

			if (!bl)
				max = Math.max(sum, max);

		}
	}

}
