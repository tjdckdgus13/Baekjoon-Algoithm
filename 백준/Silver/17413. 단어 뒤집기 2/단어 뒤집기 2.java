import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				while (true) {
					if (s.charAt(i) == '>') {
						sb.append(s.charAt(i));
						break;
					} else {
						sb.append(s.charAt(i));
						i++;

					}

				}

			} else if (s.charAt(i) == ' ') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());

				}
				sb.append(' ');
			} else {

				stack.push(s.charAt(i));
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
