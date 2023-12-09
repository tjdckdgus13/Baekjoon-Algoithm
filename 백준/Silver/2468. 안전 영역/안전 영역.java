import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, max;
	static int[][] map;
	static int[] X = { -1, 0, 1, 0 }, Y = { 0, 1, 0, -1 };
	static boolean[][] bl;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		max = 0;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		int result = 0;
		for (int i = 0; i < max; i++) {
			bl = new boolean[N][N];
			int count = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!bl[j][k] && map[j][k] > i) {
						dfs(j, k, i);
						count++;
					}
				}
			}
			result = Math.max(result, count);
		}
        
		System.out.println(result);
	}

	public static void dfs(int x, int y, int height) {
		bl[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int moveY = y + Y[i];
			int moveX = x + X[i];

			if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= N || map[moveX][moveY] <= height) {
				continue;
			}

			if (!bl[moveX][moveY]) {
				dfs(moveX, moveY, height);
			}
		}
	}
}
