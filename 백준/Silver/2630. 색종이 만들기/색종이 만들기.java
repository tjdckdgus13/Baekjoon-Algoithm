import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int white, blue = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
		check(0, 0, N);

		StringBuilder sb = new StringBuilder();
		sb.append(white + "\n" + blue);
		System.out.println(sb.toString());

	}

	public static void check(int y, int x, int n) {
		if (bl(y, x, n)) {
			if (arr[y][x] == 1) {
				blue++;
			} else {
				white++;
			}
			return;
		}
        
		int num = n / 2;
		check(y, x, num);
		check(y, x + num, num);
		check(y + num, x, num);
		check(y + num, x + num, num);
	}

	public static boolean bl(int y, int x, int n) {

		int w = arr[y][x];
		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if (!(arr[i][j] == w)) {
					return false;
				}
			}
		}

		return true;
	}
}
