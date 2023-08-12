import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			if (abs1 == abs2) {
				return o1 - o2;
			} else {
				return abs1 - abs2;
			}
		});

		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			int a = Integer.parseInt(br.readLine());
			if (a == 0) {
				if (pq.size() == 0) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			} else {
				pq.offer(a);
			}
		}
		System.out.println(sb);
	}
}
