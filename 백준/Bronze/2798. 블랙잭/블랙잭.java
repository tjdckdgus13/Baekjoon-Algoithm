import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int temp = 0;
		int result = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {

					temp = arr[i] + arr[j] + arr[k];

					if (temp == M) {
						System.out.println(temp);
						return;
					}

					if (temp > result && temp < M) {
						result = temp;
					}
				}
			}
		}
			System.out.println(result);
	}
}