import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int min = Integer.parseInt(st.nextToken());
		int max = min;
		for (int i = 0; i < N - 1; i++) {
			int a = Integer.parseInt(st.nextToken());
			min = Math.min(min, a);
			max = Math.max(max, a);
		}
		System.out.println(min + " " + max);

	}
}