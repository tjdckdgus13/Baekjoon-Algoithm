import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			sb.append(bfs(A, B) + "\n");
		}

		System.out.println(sb.toString());

	}

	public static String bfs(int A, int B) {

		boolean[] check = new boolean[10000];
		Queue<Node2> queue = new LinkedList<>();

		check[A] = true;
		queue.add(new Node2(A, ""));

		while (!queue.isEmpty()) {

			Node2 node = queue.poll();

			String str = node.str;

			if (node.number == B)
				return str;

			int D = node.D();
			if (!check[D]) {
				check[D] = true;
				queue.add(new Node2(D, str + "D"));
			}

			int S = node.S();
			if (!check[S]) {
				check[S] = true;
				queue.add(new Node2(S, str + "S"));
			}

			int L = node.L();
			if (!check[L]) {
				check[L] = true;
				queue.add(new Node2(L, str + "L"));
			}

			int R = node.R();
			if (!check[R]) {
				check[R] = true;
				queue.add(new Node2(R, str + "R"));
			}

		}

		return "";
	}

}

class Node2 {
	int number;
	String str;

	public Node2(int number, String str) {
		this.number = number;
		this.str = str;
	}

	int D() {

		return (number * 2) % 10000;
	}

	int S() {

		return number == 0 ? 9999 : number - 1;
	}

	int L() {

		return (number % 1000) * 10 + number / 1000;
	}

	int R() {

		return (number % 10) * 1000 + number / 10;
	}

}
