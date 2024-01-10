import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String ac = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			AC(ac, n, arr);
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void AC(String ac, int n, String arr) {
		Deque<Integer> stack = new ArrayDeque<>();

		arr = arr.replace("[", "").replace("]", "");
		String[] str = arr.split(",");
		for (int i = 0; i < n; i++) {
			stack.add(Integer.parseInt(str[i]));
		}

		boolean bl = false;
		for (int i = 0; i < ac.length(); i++) {
			char c = ac.charAt(i);

			if (c == 'R') {
				bl = !bl;
				continue;
			}

			if (c == 'D') {
				if (stack.isEmpty()) {
					sb.append("error");
					return;
				}

				if (!bl) {
					stack.pollFirst();
				} else {
					stack.pollLast();
				}
			}
		}

		int[] a = new int[stack.size()];
        
		for (int i = 0; i < a.length; i++) {
			a[i] = !bl ? stack.pollFirst() : stack.pollLast();
		}

		make(a);
	}

	public static void make(int[] arr) {

		sb.append("[");

		if (arr.length > 0) {
			sb.append(arr[0]);

			for (int i = 1; i < arr.length; i++) {
				sb.append("," + arr[i]);
			}
		}

		sb.append("]");
	}
}
