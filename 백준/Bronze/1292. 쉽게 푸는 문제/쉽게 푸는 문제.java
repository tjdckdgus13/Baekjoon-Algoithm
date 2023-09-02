import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i = 1; i <= 1000; i++) {
			for (int j = 0; j < i; j++) {
				arr.add(i);
			}
		}

		int sum = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		for (int i = a; i <= b; i++) {
			sum += arr.get(i - 1);
		}

		System.out.println(sum);
	}
}