import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int endX;
	static int endY;
	static int[] X = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] Y = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static boolean[][] check;
	static int N;
	static int map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());

			check = new boolean[N][N];
			map = new int[N][N];

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());

			sb.append(bfs(x, y) + "\n");
		}

		System.out.println(sb.toString());
	}

	public static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, 0 });
		check[x][y] = true;

		while (!queue.isEmpty()) {
			int[] a = queue.poll();

			if (a[0] == endX && a[1] == endY) {
				return map[endX][endY];
			}

			for (int i = 0; i < 8; i++) {
				int moveX = X[i] + a[0];
				int moveY = Y[i] + a[1];
				int num = a[2] + 1;
				if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= N) {
					continue;
				}

				if (!check[moveX][moveY]) {
					map[moveX][moveY] = num;
					queue.add(new int[] { moveX, moveY, num });
					check[moveX][moveY] = true;
				}
			}
		}
		return map[endX][endY];
	}
}
