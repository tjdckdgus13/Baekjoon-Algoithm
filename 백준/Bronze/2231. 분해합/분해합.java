import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			int number = i;
			int sum = 0;
			
			while(number != 0 ) {
				sum += number % 10;
				number /= 10;
			}
			
			if (sum + i == N) {
				count = i;
				break;
			}
		}
		
		System.out.println(count);
		
	}
}