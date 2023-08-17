import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			
			int n = Integer.parseInt(br.readLine());

			StringBuffer sb = new StringBuffer(Integer.toBinaryString(n));
			String K = sb.reverse().toString();

			for (int j = 0; j < K.length(); j++) {
				if (K.charAt(j) - '0' == 1) {
					System.out.print(j + " ");
					
				}
			}
			System.out.println("");
			
		}

	}

}
