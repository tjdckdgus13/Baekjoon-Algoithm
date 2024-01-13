import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<String> arr = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			arr.add(st.nextToken());
		}

		for (int i = 1; i < arr.size(); i++) {
			String str = "";
			String ans = "";
			for (int j = 0; j < arr.get(i).length(); j++) {
				if (arr.get(i).charAt(j) == ',' || arr.get(i).charAt(j) == ';') {
					continue;
				}
				if (arr.get(i).charAt(j) == '[') {
					str += "][";
					j++;
					continue;
				}
				if (arr.get(i).charAt(j) == '*' || arr.get(i).charAt(j) == '&') {
					str += arr.get(i).charAt(j);
					continue;
				}

				ans += arr.get(i).charAt(j);

			}
			StringBuffer sb = new StringBuffer(str);
			str = sb.reverse().toString();
			ans += ';';

			System.out.println(arr.get(0) + str + " " + ans);
		}
	}
}