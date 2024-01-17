import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static boolean[][] visit;
	static int N, M;
	static int[] X = { 1, 0, -1, 0 };
	static int[] Y = { 0, 1, 0, -1 };
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visit = new boolean[N][M];

		int y = 0;
		int x = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'I') {
					y = i;
					x = j;
				}
				map[i][j] = str.charAt(j);
			}
		}
		visit[y][x] = true;
		bfs(x, y);

		if (count == 0) {
			System.out.println("TT");
		} else {
			System.out.println(count);
		}
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] a = queue.poll();

			for (int i = 0; i < 4; i++) {
				int xmove = X[i] + a[0];
				int ymove = Y[i] + a[1];

				if (xmove < 0 || xmove >= M || ymove < 0 || ymove >= N || visit[ymove][xmove]) {
					continue;
				}

				if (map[ymove][xmove] == 'X') {
					visit[ymove][xmove] = true;
					continue;
				}

				queue.add(new int[] { xmove, ymove });
				visit[ymove][xmove] = true;

				if (map[ymove][xmove] == 'P')
					count++;

			}
		}
	}

}
