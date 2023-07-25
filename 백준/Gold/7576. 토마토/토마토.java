import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] X = { 1, 0, -1, 0 };
	static int[] Y = { 0, 1, 0, -1 };
	static int N;
	static int M;
	static int[][] map;
	static int count = Integer.MIN_VALUE;
	static Queue<int[]> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					queue.add(new int[] { i, j });
				}
			}
		}

		bfs();
		System.out.println(count == -1 ? count : count - 1);

	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] a = queue.poll();
			for (int i = 0; i < 4; i++) {
				int xmove = a[1] + X[i];
				int ymove = a[0] + Y[i];

				if (xmove >= M || ymove >= N || xmove < 0 || ymove < 0 || map[ymove][xmove] == -1) {
					continue;
				}

				if (map[ymove][xmove] == 0) {
					map[ymove][xmove] = map[a[0]][a[1]] + 1;
					queue.add(new int[] { ymove, xmove });
					continue;
				}

			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					count = -1;
					return;
				} else {
					count = Math.max(map[i][j], count);
				}
			}
		}
	}

}
