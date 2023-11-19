import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			check(str);
		}

		System.out.println(sb);
	}

	public static void check(String st) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < st.length(); i++) {
			char c = st.charAt(i);

			if (c == '(') {
				stack.add(c);
			} else if (c == ')' && !stack.isEmpty()) {
				stack.pop();
			} else {
				sb.append("NO" + "\n");
				return;
			}
			
		}
		if (stack.isEmpty()) {
			sb.append("YES" + "\n");
		} else {
			sb.append("NO" + "\n");
		}
	}
}