import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> q;
	static int b =0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		q = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			if (st.countTokens() == 1) {
				String str1 = st.nextToken();
				String str2 = "0";
				queue(str1, str2);
			} else {
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				queue(str1, str2);
			}
		}
		System.out.println(sb);
	}

	public static void queue(String queue, String X) {
		
		int a = 0;
	
		switch (queue) {
		case "push":
			a = Integer.parseInt(X);
			b = a;
			q.add(a);
			break;
		case "pop":
			if (q.isEmpty()) {
				sb.append(-1 + "\n");
			} else {
				sb.append(q.poll()+ "\n");
			}
			break;
		case "size":
			sb.append(q.size() + "\n");
			break;
		case "empty":
			if (q.isEmpty()) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
			break;
		case "front":
			if (!q.isEmpty()) {
				sb.append(q.peek() + "\n");
			} else {
				sb.append(-1 + "\n");
			}
			break;
		case "back":
			if (q.isEmpty()) {
				sb.append(-1 + "\n");
			} else {
				sb.append(b + "\n");
			}
			break;
		}
	}
}