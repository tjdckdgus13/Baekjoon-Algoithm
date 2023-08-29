import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = N;
		int count = 0;
		while (true) {
			M = (((M / 10) + (M % 10)) % 10) + ((M % 10) * 10);
			count++;
			if (M == N)
				break;
		}
		System.out.println(count);
	}

}
