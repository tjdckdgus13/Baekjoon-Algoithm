import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		recursion(R, C, (int) Math.pow(2, N));
		System.out.println(count);
	}

	public static void recursion(int r, int c, int n) {
		if (n == 1) {
			return;
		}

		int a = n / 2;

		if (r < a && c < a) {
			recursion(r, c, a);
		} else if (r < a && c >= a) {
			count += n * n / 4;
			recursion(r, c - a, a);
		} else if (r >= a && c < a) {
			count += (n * n / 4) * 2;
			recursion(r - a, c, a);
		} else {
			count += (n * n / 4) * 3;
			recursion(r - a, c - a, a);
		}

	}

}
