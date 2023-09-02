import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int count = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			if (L == 0 && P == 0 && V == 0)
				break;

			int result = L * (V / P) + Math.min(L, (V % P));

			bw.write("Case " + count++ + ": " + result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
