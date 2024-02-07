import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String str = br.readLine();

		while (str.contains("LL")) {
			str = str.replaceFirst("LL", "S");
		}

		int count = str.length() + 1;

		System.out.println(N > count ? count : N);
	}

}
