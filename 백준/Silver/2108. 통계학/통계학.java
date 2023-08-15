import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int a[] = new int[8001];
		double sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			a[arr[i] + 4000]++;
		}

		sb.append((int) Math.round((double) sum / N) + "\n");
		Arrays.sort(arr);

		sb.append(arr[N / 2] + "\n");
		int max = 0;
		for (int i = 0; i < 8001; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}

		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 0; i < 8001; i++) {
			if (a[i] == max) {
				ar.add(i - 4000);
			}
		}

		if (ar.size() == 1) {
			sb.append(ar.get(0) + "\n");
		} else {
			sb.append(ar.get(1) + "\n");
		}

		if (arr.length == 1) {
			sb.append(0);
		} else {
			sb.append(arr[N - 1] - arr[0]);
		}
		System.out.println(sb);
	}
}