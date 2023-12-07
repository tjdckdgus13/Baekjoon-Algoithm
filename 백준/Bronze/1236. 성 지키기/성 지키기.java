import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int a = 0;
		for (int i = 0; i < N; i++) {
			boolean bl = false;
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'X') {
					bl = true;
					break;
				}
			}
			if (!bl)
				a++;
		}

		int b = 0;
		for (int i = 0; i < M; i++) {
			boolean bl = false;
			for (int j = 0; j < N; j++) {
				if (arr[j][i] == 'X') {
					bl = true;
					break;
				}
			}
			if (!bl)
				b++;
		}
		System.out.println(Math.max(a, b));
	}
}
