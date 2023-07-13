import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] X = { 1, 0, -1, 0 };
	static int[] Y = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] move = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] a = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(a[j]);
				move[i][j] = -1;
			}
		}
		bfs(N - 1, M - 1, map, move);
	}

	static void bfs(int N, int M, int[][] map, int[][] move) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { 0, 0 });
		move[0][0] = 1;

		while (!queue.isEmpty()) {
			int[] a = queue.poll();

			for (int i = 0; i < 4; i++) {
				int x = a[1] + X[i];
				int y = a[0] + Y[i];

				if (x > M || y > N || x < 0 || y < 0) {
					continue;
				}

				if (move[y][x] != -1 || map[y][x] == 0) {
					continue;
				}

				move[y][x] = move[a[0]][a[1]] + 1;
				queue.add(new int[] { y, x });
			}
		}

		System.out.println(move[N][M]);
	}
}
