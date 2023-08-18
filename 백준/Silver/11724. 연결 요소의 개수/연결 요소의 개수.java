import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N;
	static int M;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		v = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = map[b][a] = 1;
		}
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (!v[i]) {
				dfs(i);
				result++;
			}
		}
		System.out.println(result);
	}

	static void dfs(int idx) {
		if (v[idx]) {
			return;
		}
		v[idx] = true;
		for (int i = 1; i <= N; i++) {
			if (map[idx][i] == 1) {
				dfs(i);
			}
		}
	}
}
