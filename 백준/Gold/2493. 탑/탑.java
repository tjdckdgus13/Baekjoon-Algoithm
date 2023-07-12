import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Top> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				sb.append(0 + " ");
				stack.add(new Top(num, i + 1));
			} else {
				while (true) {
					if (stack.isEmpty()) {
						sb.append(0 + " ");
						stack.add(new Top(num, i + 1));
						break;
					}

					Top top = stack.peek();

					if (top.height > num) {
						sb.append(top.idx + " ");
						stack.add(new Top(num, i + 1));
						break;
					} else {
						stack.pop();
					}
				}
			}
		}
		System.out.println(sb.toString());
	}

}

class Top {
	int height;
	int idx;

	Top(int height, int idx) {
		this.height = height;
		this.idx = idx;
	}
}
