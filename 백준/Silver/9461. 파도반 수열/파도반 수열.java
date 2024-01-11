import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] arr = new long[101];

		arr[1] = 1;
		arr[2] = 1;

		for (int i = 3; i <= 100; i++) {
			arr[i] = arr[i - 2] + arr[i - 3];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());

			sb.append(arr[n] + "\n");
		}

		System.out.println(sb.toString());
	}

}
