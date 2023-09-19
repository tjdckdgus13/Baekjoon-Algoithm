import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int tree[] = new int[N];

		int min = 0;
		int max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			tree[i] = num;
			max = Math.max(max, num);
		}

		while (min <= max) {
			int mid = (min + max) / 2;
			long sum = 0;

			for (int i = 0; i < N; i++) {
				if (tree[i] > mid) {
					sum += tree[i] - mid;
				}
			}

			if (M <= sum) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		System.out.println(max);

	}
}