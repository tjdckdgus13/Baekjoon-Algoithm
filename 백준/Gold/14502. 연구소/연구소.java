import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] X = { 1, 0, -1, 0 };
	static int[] Y = { 0, 1, 0, -1 };

	static int result = Integer.MIN_VALUE;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, map);

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();

	}

	static void dfs(int c, int[][] map) {
		if (c == 3) {
			bfs(map);
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(c + 1, map);
					map[i][j] = 0;
				}
			}
		}
	}

	static void bfs(int[][] origin) {
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = origin[i].clone();
		}

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					queue.add(new int[] { i, j });
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] a = queue.poll();
			int x = a[1];
			int y = a[0];

			for (int i = 0; i < 4; i++) {
				int xmove = x + X[i];
				int ymove = y + Y[i];

				if (xmove >= M || xmove < 0 || ymove >= N || ymove < 0) {
					continue;
				}

				if (map[ymove][xmove] == 0) {
					map[ymove][xmove] = 2;
					queue.add(new int[] { ymove, xmove });
				}
			}
		}
		check(map);
	}

	static void check(int[][] map) {
		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					num++;
				}
			}
		}
		result = Math.max(result, num);
	}
}
