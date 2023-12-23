import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visit = new boolean[100001];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		if (n == k) {
			System.out.println(0);
		} else {
			bfs(n, k);
			System.out.println(min);
		}
	}

	public static void bfs(int n, int k) {
		Queue<Node1> queue = new LinkedList<>();

		queue.add(new Node1(n, 0));
		while (!queue.isEmpty()) {
			Node1 node = queue.poll();
			int i = node.idx;
			int t = node.time;

			if (i == k) {
				min = Math.min(t, min);
			}

			if (i * 2 <= 100000 && !visit[i * 2]) {
				queue.add(new Node1(i * 2, t));
				visit[i * 2] = true;
			}

			if (i - 1 >= 0 && !visit[i - 1]) {
				queue.add(new Node1(i - 1, t + 1));
				visit[i - 1] = true;
			}

			if (i + 1 <= 100000 && !visit[i + 1]) {
				queue.add(new Node1(i + 1, t + 1));
				visit[i + 1] = true;
			}

		}
	}

}

class Node1 {
	int idx, time;

	Node1(int idx, int time) {
		this.idx = idx;
		this.time = time;
	}
}
