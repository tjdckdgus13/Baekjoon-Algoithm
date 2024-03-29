import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		String subst = br.readLine();
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < st.length(); i++) {

			stack.add(st.charAt(i));

			if (stack.size() >= subst.length()) {

				boolean flag = true;

				for (int j = 0; j < subst.length(); j++) {
					if (stack.get(stack.size() - subst.length() + j) != subst.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < subst.length(); j++) {
						stack.pop();
					}
				}
			}

		}

		if (stack.size() == 0) {
			System.out.println("FRULA");
		} else {
			for (int i = 0 ; i < stack.size() ; i++) { 
				sb.append(stack.get(i));
			}
			System.out.println(sb);
		}
	}
}
