import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			long a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0)
				break;

			if ((a * a) + (b * b) == c * c) {
				sb.append("right" + "\n");
			} else if ((a * a) + (c * c) == b * b) {
				sb.append("right" + "\n");
			} else if ((b * b) + (c * c) == a * a) {
				sb.append("right" + "\n");
			} else {
				sb.append("wrong" + "\n");
			}
		}

		System.out.println(sb);

	}
}