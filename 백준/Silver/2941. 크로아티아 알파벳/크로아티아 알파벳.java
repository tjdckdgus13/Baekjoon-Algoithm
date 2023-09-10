import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] a = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		String str = br.readLine();

		if (str.length() > 1) {
			for (int i = 0; i < 8; i++) {
				if (str.contains(a[i])) {
					str = str.replaceAll(a[i], " ");
				}
			}
		}
		System.out.println(str.length());
	}
}
