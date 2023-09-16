import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		String x = sb.append(st.nextToken()).reverse().toString();
		sb = new StringBuilder();
		String y = sb.append(st.nextToken()).reverse().toString();
		sb = new StringBuilder();
		int result = Integer.parseInt(sb.append(Integer.parseInt(x) + Integer.parseInt(y)).reverse().toString());
		System.out.println(result);
	}
}
