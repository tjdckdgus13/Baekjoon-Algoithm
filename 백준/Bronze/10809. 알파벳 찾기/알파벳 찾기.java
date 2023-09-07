import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		StringBuilder sb = new StringBuilder();
		String[] a = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
				"t", "u", "v", "w", "x", "y", "z" };

		for (int i = 0; i < a.length; i++) {
			if (S.contains(a[i])) {
				sb.append(S.indexOf(a[i]) + " ");
			} else {
				sb.append("-1 ");
			}
		}
		System.out.println(sb.toString());
	}
}
