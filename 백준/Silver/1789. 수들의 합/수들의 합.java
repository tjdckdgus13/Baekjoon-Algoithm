import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		long sum = 0;
		int count = 1;
		while(N > sum) {
			count++;
			sum += count;
		}
		
		System.out.println(count-1);
	}
}