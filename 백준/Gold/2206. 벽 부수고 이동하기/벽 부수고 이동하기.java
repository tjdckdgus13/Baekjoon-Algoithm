import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] X = { 1, 0, -1, 0 };
	static int[] Y = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][][] visit;
	static int N, M;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == '1') {
					map[i][j] = 1;
				}
			}
		}

		bfs();

		System.out.println(min != Integer.MAX_VALUE ? min : -1);

	}

	public static void bfs() {
		Queue<What> queue = new LinkedList<>();
		queue.add(new What(0, 0, false, 1));
		visit[0][0][0] = true;

		while (!queue.isEmpty()) {
			What what = queue.poll();

			if (what.x == M - 1 && what.y == N - 1) {
				min = Math.min(min, what.count);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int xmove = X[i] + what.x;
				int ymove = Y[i] + what.y;

				if (xmove < 0 || xmove >= M || ymove < 0 || ymove >= N) {
					continue;
				}

				if (map[ymove][xmove] == 1) {

					if (!what.flag && !visit[ymove][xmove][1]) {
						queue.add(new What(xmove, ymove, true, what.count + 1));
						visit[ymove][xmove][1] = true;
					}

				} else {

					if (!visit[ymove][xmove][0] && !what.flag) {
						queue.add(new What(xmove, ymove, false, what.count + 1));
						visit[ymove][xmove][0] = true;

					} else if (!visit[ymove][xmove][1] && what.flag) {
						queue.add(new What(xmove, ymove, true, what.count + 1));
						visit[ymove][xmove][1] = true;
					}

				}
			}
		}
	}

}

class What {
	int x;
	int y;
	boolean flag;
	int count;

	public What(int x, int y, boolean flag, int count) {
		this.x = x;
		this.y = y;
		this.flag = flag;
		this.count = count;
	}

}
