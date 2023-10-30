import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		while (true) {
			String str = br.readLine();

			if (str.equals(".")) {
				break;
			}
			check(str);
		}
		System.out.println(sb);
	}

	public static void check(String str) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);
			if (c == '(') {
				stack.add('(');
			} else if (c == '[') {
				stack.add('[');
			} else if (c == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					sb.append("no" + "\n");
					return;
				} else {
					stack.pop();
				}
			} else if (c == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					sb.append("no" + "\n");
					return;
				} else {
					stack.pop();
				}
			}
		}
       
		if (stack.isEmpty()) {
			sb.append("yes" + "\n");
		} else {
			sb.append("no" + "\n");
		}
	}
}