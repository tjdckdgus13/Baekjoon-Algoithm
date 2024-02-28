import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static Set<String> set = new LinkedHashSet<>();
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb;
	static int[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visit = new boolean[N];
		check = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		make(0);

		sb = new StringBuilder();
		for (String i : set) {
			sb.append(i + "\n");
		}

		System.out.println(sb.toString());
	}

	public static void make(int idx) {
		if (idx == M) {
            
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {

				sb.append(check[i] + " ");
			}

			set.add(sb.toString());
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i]) {
				continue;
			}

			check[idx] = arr[i];
			visit[i] = true;
			make(idx + 1);
			visit[i] = false;
		}
	}

}
