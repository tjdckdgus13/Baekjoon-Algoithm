import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max = 0;
		int count = 0;
		int num = 0;
		for (int i = 0; i < 9; i++) {
			int a = Integer.parseInt(br.readLine());
			count ++;
			if (max < a) {
				max = a;
				num = count;
			}
		}
		
		System.out.println(max);
		System.out.println(num);
	}
}