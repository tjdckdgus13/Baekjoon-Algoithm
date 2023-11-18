import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
	
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int a = 1;
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'O') {
					count += a++;
				} else {
					a = 1;
				}
			}
			sb.append(count + "\n");
		}
		
		System.out.println(sb);
	}
}