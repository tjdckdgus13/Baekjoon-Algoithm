import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] v = new int[w];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}

		int l = 0;
		int r = 0;
		int sum = 0;
		for (int i = 1; i < w - 1; i++) {
			l = 0;
			r = 0;
			for (int j = 0; j < i; j++) {
				l = Math.max(v[j], l);
			}

			for (int j = i + 1; j < w; j++) {
				r = Math.max(v[j], r);
			}

			if (l > v[i] && r > v[i]) {
				sum += Math.min(l, r) - v[i];
			}
		}

		bw.write(String.valueOf(sum));
		bw.close();
	}
}
