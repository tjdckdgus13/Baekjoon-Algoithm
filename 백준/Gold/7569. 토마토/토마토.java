import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] map;
	static Queue<tomato> queue;
	static int[] H = { 1, -1 };
	static int[] X = { 1, 0, -1, 0 };
	static int[] Y = { 0, 1, 0, -1 };
	static int m;
	static int n;
	static int h;
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h][n][m];
		queue = new LinkedList<>();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < m; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1) {
						queue.add(new tomato(i, j, k));
					}
				}
			}
		}
		bfs();
		check();
		System.out.println(result == -1 ? -1 : result - 1);
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			tomato t = queue.poll();

			int ih = t.h;
			int in = t.n;
			int im = t.m;
			for (int i = 0; i < 2; i++) {
				int hmove = ih + H[i];
				if (hmove < 0 || hmove >= h)
					continue;

				if (map[hmove][in][im] == 0) {
					map[hmove][in][im] = map[ih][in][im] + 1;
					queue.add(new tomato(hmove, in, im));
				}

			}

			for (int i = 0; i < 4; i++) {
				int xmove = im + X[i];
				int ymove = in + Y[i];

				if (xmove >= m || xmove < 0 || ymove >= n || ymove < 0)
					continue;

				if (map[ih][ymove][xmove] == 0) {
					map[ih][ymove][xmove] = map[ih][in][im] + 1;
					queue.add(new tomato(ih, ymove, xmove));
				}
			}
		}
	}

	static void check() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[i][j][k] == 0) {
						result = -1;
						return;
					}
					result = Math.max(result, map[i][j][k]);
				}
			}
		}
	}
}

class tomato {
	int h;
	int n;
	int m;

	public tomato(int h, int n, int m) {
		this.h = h;
		this.n = n;
		this.m = m;
	}
}
