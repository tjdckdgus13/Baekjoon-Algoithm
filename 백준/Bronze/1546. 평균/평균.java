import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		double list[] = new double[N];
		for (int i = 0; i < N; i++) {
			list[i] =  Double.parseDouble(st.nextToken());
		}

		Arrays.sort(list);

		double sum = 0;
		for (int i = 0; i < N ; i++) {
			sum += ((list[i] / list[N - 1]) * 100);
		}

	
		System.out.println(sum / N);

	}
}