import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");

			for (int j = 0; j < arr.length; j++) {
				StringBuilder sb2 = new StringBuilder();
				sb2.append(arr[j]).reverse();
				sb1.append(sb2 + " ");
			}
			sb1.append("\n");
		}
		System.out.println(sb1.toString());
	}
}
