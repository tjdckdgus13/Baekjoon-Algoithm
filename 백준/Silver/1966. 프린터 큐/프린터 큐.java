import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<int[]> q = new LinkedList<int[]>();
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			q = new LinkedList<int[]>();
			for (int j = 0; j < N; j++) {
				q.offer(new int[] { j, Integer.parseInt(st.nextToken()) });
			}

			int count = 0;
			while (!q.isEmpty()) {
				int first[] = q.poll();
				boolean bl = true;
				for (int j = 0; j < q.size(); j++) {
					if (first[1] < q.get(j)[1]) {
						q.add(first);

						for (int k = 0; k < j; k++) {
							q.add(q.poll());
						}
						bl = false;
						break;

					}
				}
				if (bl == false) {
					continue;
				}

				count++;

				if (first[0] == M) {
					break;
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}
}