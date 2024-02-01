import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] check = new boolean[100001];

		for (int i = 1; i <= 10000; i++) {
			int n = num(i);

			check[n] = true;
		}

		for (int i = 1; i <= 10000; i++) {
			if (!check[i]) {
				sb.append(i + "\n");
			}
		}

		System.out.println(sb.toString());
	}

	public static int num(int n) {
		String[] a = String.valueOf(n).split("");

		int count = 0;
		for (int i = 0; i < a.length; i++) {
			count += Integer.parseInt(a[i]);
		}

		return count + n;
	}

}
