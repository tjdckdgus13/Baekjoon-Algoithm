import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static boolean[] visit;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;

			arr = new int[N];
			visit = new boolean[N];

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			check(0, 0);

			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	public static void check(int start, int idx) {
		if (idx == 6) {
			for (int i = 0; i < N; i++) {
				if (visit[i])
					sb.append(arr[i] + " ");
			}
			sb.append("\n");
		}

		for (int i = start; i < N; i++) {
			visit[i] = true;
			check(i + 1, idx + 1);
			visit[i] = false;
		}
	}

}
