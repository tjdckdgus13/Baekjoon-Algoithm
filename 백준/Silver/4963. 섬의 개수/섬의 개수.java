import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int X[] = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int Y[] = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int map[][];
	static boolean[][] check;
	static int w;
	static int h;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (!(w == 0 && h == 0)) {
				map = new int[w][h];
				check = new boolean[w][h];
				for (int i = 0; i < h; i++) {
					st = new StringTokenizer(br.readLine());
					for (int j = 0; j < w; j++) {
						int a = Integer.parseInt(st.nextToken());
						map[j][i] = a;
						if (a == 1) {
							check[j][i] = true;
						}
					}
				}
				int count = 0;
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						if (check[j][i] == true) {
							dfs(j, i);
							count++;
						}
					}
				}

				sb.append(count + "\n");
			} else {
				break;
			}
		}
		System.out.println(sb);
	}

	public static void dfs(int x, int y) {
		check[x][y] = false;

		for (int i = 0; i < 8; i++) {
			int dx = x + X[i];
			int dy = y + Y[i];
			if (dx >= 0 && dx < w && dy >= 0 && dy < h) {
				if (check[dx][dy] == true && map[dx][dy] == 1) {
					dfs(dx, dy);
				}
			}
		}
	}
}