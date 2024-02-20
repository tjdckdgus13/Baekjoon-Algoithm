import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static boolean[] visit;
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visit = new boolean[N];

		check(0);

		System.out.println(sb.toString());
	}

	public static void check(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[idx] = i + 1;
				check(idx + 1);
				visit[i] = false;
			}
		}
	}

}
