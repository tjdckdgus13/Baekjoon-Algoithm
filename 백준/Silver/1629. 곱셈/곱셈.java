import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long A, B, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		System.out.println(dfs(B) % C);

	}

	public static long dfs(long b) {
		if (b == 0)
			return 1;

		long num = dfs(b / 2);

		if (b % 2 == 0) {
			return (num * num) % C;
		}

		return (num * num % C) * A % C;
	}

}
