import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < 2; i++) {
			num *= Integer.parseInt(br.readLine());
		}

		String to = Integer.toString(num);
		int arr[] = new int[10];
		for (int i = 0; i < to.length(); i++) {
			char a = to.charAt(i);
			int b = a - '0';
			arr[b] += 1;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}