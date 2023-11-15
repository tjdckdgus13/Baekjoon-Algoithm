import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] A;
	static int[] B;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		B = new int[4];
		for (int i = 0; i < 4; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		arr(A[0], 1);

		System.out.println(max);
		System.out.println(min);
	}

	public static void arr(int num, int idx) {
		if (idx == N) {
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (B[i] > 0) {
				B[i]--;
				if (i == 0)
					arr(num + A[idx], idx + 1);
				else if (i == 1)
					arr(num - A[idx], idx + 1);
				else if (i == 2)
					arr(num * A[idx], idx + 1);
				else if (i == 3)
					arr(num / A[idx], idx + 1);

				B[i]++;
			}
		}
	}
}