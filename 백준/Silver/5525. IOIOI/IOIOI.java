import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] c = br.readLine().toCharArray();

		int count = 0;
		int result = 0;
		for (int i = 1; i < M - 1; i++) {
			if (c[i - 1] == 'I' && c[i] == 'O' && c[i + 1] == 'I') {
				count++;

				if (count == N) {
					count--;
					result++;
				}
				i++;

			} else {
				count = 0;
			}

		}

		System.out.println(result);
	}

}
