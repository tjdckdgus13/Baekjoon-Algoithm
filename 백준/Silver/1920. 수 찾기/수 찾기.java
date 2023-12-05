import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] Alist;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Alist = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Alist[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(Alist);

		int M = Integer.parseInt(br.readLine());
		int Blist[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			Blist[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int Bnum = Blist[i];
			
			if (num(Bnum) == 0) {
				sb.append(0 + "\n");
			}
		}

		System.out.println(sb);
	}

	public static int num(int Bnum) {
		int high = Alist.length - 1;
		int low = 0;

		while (high >= low) {

			int mid = (high + low) / 2;

			if (Bnum == Alist[mid]) {
				sb.append(1 + "\n");
				return 1;
			} else if (Bnum > Alist[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return 0;
	}
}