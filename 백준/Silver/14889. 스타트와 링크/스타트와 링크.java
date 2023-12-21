import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N;
	static boolean[] bl;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		bl = new boolean[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		search(0, 0);

		System.out.println(min);
	}

	public static void search(int idx, int num) {
		if (N / 2 == num) {
			check();
			return;
		}

		for (int i = idx; i < N; i++) {
			bl[i] = true;
			search(i + 1, num + 1);
			bl[i] = false;
		}
	}

	public static void check() {

		int firstTeam = 0;
		int secondTeam = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (bl[i] && bl[j]) {
					firstTeam += arr[i][j];
					firstTeam += arr[j][i];
				}

				if (!bl[i] && !bl[j]) {
					secondTeam += arr[i][j];
					secondTeam += arr[j][i];
				}
			}
		}

		min = Math.min(Math.abs(firstTeam - secondTeam), min);

		if (min == 0) {
			System.out.println(min);
			System.exit(0);
		}
	}
}
