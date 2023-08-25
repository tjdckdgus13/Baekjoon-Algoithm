import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		for (int i = 0; i < T; i++) {	
			int a = Integer.parseInt(st.nextToken());	
			if (a == 1 ) {
				continue;
			}
			boolean check = true;
			for (int j = 2; j < a; j++) {
				if (a % j == 0) {
					check = false;
					break;
				}
			}
			if (check)
				count++;
		}
		System.out.println(count);
	}
}