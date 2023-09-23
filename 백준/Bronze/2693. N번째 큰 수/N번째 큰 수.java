import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 10; j++) {

				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			sb.append(arr[7] + "\n");

		}
		System.out.println(sb);
	}
}
