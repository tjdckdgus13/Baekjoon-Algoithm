import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int B, N, M, min, max;
	static int map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);

			}
		}
		check();
	}

	public static void check() {

		int time = Integer.MAX_VALUE;
		int height = 0;
		for (int i = min; i <= max; i++) {

			int t = 0;
			int inv = B;

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					int dif = map[j][k] - i;
					if (dif > 0) {
						t += Math.abs(dif) * 2;
						inv += Math.abs(dif);
					} else if (dif < 0) {
						t += Math.abs(dif);
						inv -= Math.abs(dif);
					}
				}

			}

			if (inv < 0) {
				break;
			}

			if (time >= t) {
				time = t;
				height = i;
			}
		}
		System.out.println(time + " " + height);
	}
}