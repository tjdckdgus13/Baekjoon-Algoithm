import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[] bl;
	static int n;
	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		map = new int[n + 1][n + 1];
		bl = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}
		dfs(1);
		System.out.println(count);
	}

	static void dfs(int num) {
		bl[num] = true;

		for (int j = 1; j <= n; j++) {
			if (map[num][j] == 1 && bl[j] == false) {
				count++;
				dfs(j);
			}
		}
	}

}
