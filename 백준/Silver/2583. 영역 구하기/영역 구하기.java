import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] X = { -1, 0, 1, 0 };
	static int[] Y = { 0, -1, 0, 1 };
	static int count;
	static int M;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					map[j][k] = 1;
				}
			}
		}

		for (int j = 0; j < M; j++) {
			for (int k = 0; k < N; k++) {
				if (map[k][j] == 0) {
					map[k][j] = 1;
					dfs(k, j);
					list.add(count);
					count = 0;
				}
			}
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
        sb.append(list.size() + "\n");
		for (int i : list) {
			sb.append(i + " ");
		}

		System.out.println(sb.toString());
	}

	public static void dfs(int x, int y) {
		count++;

		for (int i = 0; i < 4; i++) {
			int moveX = x + X[i];
			int moveY = y + Y[i];

			if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= M || map[moveX][moveY] == 1) {
				continue;
			}

			map[moveX][moveY] = 1;
			dfs(moveX, moveY);
		}
	}
    
}
