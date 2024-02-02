import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
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
		if (idx == M) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = num; i <= N; i++) {

			arr[idx] = i;
			dfs(i + 1, idx + 1);
		}
	}

}
