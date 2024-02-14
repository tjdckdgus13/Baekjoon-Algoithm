import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Deque<Integer> queue = new ArrayDeque<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String str = st.nextToken();
			int num = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

			switch (str) {
			case "push":
				queue.add(num);
				break;
			case "pop":
				sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				sb.append(queue.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(!queue.isEmpty() ? queue.peekFirst() : -1).append("\n");
				break;
			case "back":
				sb.append(!queue.isEmpty() ? queue.peekLast() : -1).append("\n");
				break;
			}
		}

		System.out.println(sb.toString());
	}
}
