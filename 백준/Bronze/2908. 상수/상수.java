import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		String b = st.nextToken();

		StringBuffer sb = new StringBuffer(a);
		String re = sb.reverse().toString();

		a = re;

		sb = new StringBuffer(b);
		re = sb.reverse().toString();

		b = re;
		
		int aa = Integer.parseInt(a);
		int bb = Integer.parseInt(b);

		System.out.println(Math.max(aa, bb));
	}
}