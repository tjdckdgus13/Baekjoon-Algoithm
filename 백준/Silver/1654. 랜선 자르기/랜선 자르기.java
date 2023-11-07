import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		long max = 0;
		int arr[] = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		long high = max;
		long low = 1;
		while (high >= low) {
			long mid = (high + low) / 2;
			long sum = 0;
			for (int i = 0; i < K; i++) {
				sum += arr[i] / mid;
			}
			if (sum >= N) {
				low = mid + 1;
			} else {
				high  = mid - 1; 
			}
		}
		System.out.println(high);
	}
}