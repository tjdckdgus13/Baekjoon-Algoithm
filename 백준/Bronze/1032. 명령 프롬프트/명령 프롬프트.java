import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str[0].length(); i++) {
			boolean bl = false;
			char c = str[0].charAt(i);

			for (int j = 1; j < N; j++) {
				if (!(str[j].charAt(i) == c)) {
					bl = true;
					break;
				}
			}

			if (bl) {
				sb.append("?");
			} else {
				sb.append(c);
			}

		}

		System.out.println(sb.toString());
	}

}
