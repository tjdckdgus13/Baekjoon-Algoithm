import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String num[] = br.readLine().split(" ");

		int N = Integer.parseInt(num[0]);
		int K = Integer.parseInt(num[1]);
		int C = 0;
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				C++;

				if (C == K) {
					C = i;
					System.out.println(C);
					return;
				}
			}
		}	
		System.out.println(0);	
	}
}
