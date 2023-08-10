import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String M = br.readLine();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int a = M.charAt(i) - '0';
			sum += a;
		}

		System.out.println(sum);

	}
}