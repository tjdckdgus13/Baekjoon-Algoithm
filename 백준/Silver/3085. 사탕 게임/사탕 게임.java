import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char map[][];
	static int N;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {

				char tp = map[i][j];
				map[i][j] = map[i][j + 1];
				map[i][j + 1] = tp;

				check(map);

				tp = map[i][j];
				map[i][j] = map[i][j + 1];
				map[i][j + 1] = tp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {

				char tp = map[j][i];
				map[j][i] = map[j + 1][i];
				map[j + 1][i] = tp;

				check(map);

				tp = map[j][i];
				map[j][i] = map[j + 1][i];
				map[j + 1][i] = tp;
			}
		}

		System.out.println(max);

	}

	public static void check(char[][] map) {
		for (int i = 0; i < N; i++) {
			int count = 1;
			for (int j = 0; j < N - 1; j++) {
				if (map[i][j] == map[i][j + 1]) {
					count++;
				} else {
					count = 1;
				}
				max = Math.max(count, max);
			}
		}

		for (int i = 0; i < N; i++) {
			int count = 1;
			for (int j = 0; j < N - 1; j++) {
				if (map[j][i] == map[j + 1][i]) {
					count++;
				} else {
					count = 1;
				}
				max = Math.max(count, max);
			}
		}
	}
}