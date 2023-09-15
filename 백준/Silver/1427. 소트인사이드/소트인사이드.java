import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String[] a = br.readLine().split("");
		Arrays.sort(a);
		StringBuilder sb = new StringBuilder();
		for (int i = a.length - 1; i >= 0; i--) {
			sb.append(a[i]);
		}
		System.out.println(sb.toString());
	}
}
