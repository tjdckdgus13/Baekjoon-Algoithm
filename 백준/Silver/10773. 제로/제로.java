import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < K; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a == 0) {
				stack.pop();
			} else {
				stack.add(a);
			}
		}
		
		int sum = 0;
		for (int in : stack) {
			sum += in;
		}
		System.out.println(sum);
	}
}