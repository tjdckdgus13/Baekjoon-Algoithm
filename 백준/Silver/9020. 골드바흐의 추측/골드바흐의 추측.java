import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static boolean[] arr = new boolean[10001];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		make();

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			check(N);
		}

		System.out.println(sb.toString());
	}

	public static void make() {

		arr[0] = arr[1] = true;

		for (int i = 2; i <= Math.sqrt(10000); i++) {

			if (arr[i]) {
				continue;
			}

			for (int j = i * i; j < 10000; j += i) {
				arr[j] = true;
			}
		}
	}

	public static void check(int n) {

		int a = n / 2;
		int b = n / 2;

		while (true) {

			if (!arr[a] && !arr[b]) {
				sb.append(a + " " + b).append("\n");
				break;
			}

			a--;
			b++;
		}
	}

}
