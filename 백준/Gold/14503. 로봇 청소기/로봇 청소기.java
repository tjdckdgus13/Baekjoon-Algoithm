import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] X = { 1, 0, -1, 0 };
	static int[] Y = { 0, -1, 0, 1 };
	static int[] diretion = { 1, 0, 3, 2 };
	static int[][] map;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int look = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 4; i++) {
			if (look == diretion[i]) {
				look = i;
				break;
			}

		}

		dfs(y, x, look);
		System.out.println(result);
	}

	static void dfs(int y, int x, int look) {
		if (map[y][x] == 0) {
			map[y][x] = -1;
			result++;
		}
		for (int i = 0; i < 4; i++) {
			look = (look + 1) % 4;
			int xmove = x + X[look];
			int ymove = y + Y[look];

			if (map[ymove][xmove] == 0) {
				dfs(ymove, xmove, look);

				return;
			}
		}

		int a = (look + 2) % 4;
		y = y + Y[a];
		x = x + X[a];
		if (map[y][x] != 1) {
			dfs(y, x, look);
		}
	}
}
