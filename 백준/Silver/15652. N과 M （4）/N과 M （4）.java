import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];

		dfs(1, 0);

		System.out.println(sb.toString());
	}

	public static void dfs(int num, int idx) {
		if (M == idx) {
			for (int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = num; i <= N; i++) {
			arr[idx] = i;

			dfs(i, idx + 1);
		}
	}

}
