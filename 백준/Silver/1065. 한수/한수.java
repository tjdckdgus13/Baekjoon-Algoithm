import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int count = N < 100 ? N : 99;
		for (int i = 100; i <= N; i++) {

			int one = i / 100;
			int two = (i / 10) % 10;
			int three = i % 10;

			if ((one - two) == (two - three))
				count++;
		}

		System.out.println(count);
	}

}
