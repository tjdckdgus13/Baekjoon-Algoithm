import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static boolean[] B = new boolean[100001];
	static int[] V = new int[100001];
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
		} else {
			bfs();
			System.out.println(V[K]);
		}

	}

	private static void bfs() {
		q.add(N);

		while (!q.isEmpty()) {
			int a = q.poll();
			if (a == K)
				break;
			if (a > 0 && B[a - 1] == false) {
				q.add(a - 1);
				B[a - 1] = true;
				V[a - 1] = V[a] + 1;
			}

			if (a < 100000 && B[a + 1] == false) {
				q.add(a + 1);
				B[a + 1] = true;
				V[a + 1] = V[a] + 1;
			}

			if (a * 2 <= 100000 && B[a * 2] == false) {
				q.add(a * 2);
				B[a * 2] = true;
				V[a * 2] = V[a] + 1;
			}
		}
	}

}
