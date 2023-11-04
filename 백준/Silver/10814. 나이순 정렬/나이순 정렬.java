import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		String str[][] = new String[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			str[i][0] = st.nextToken();
			str[i][1] = st.nextToken();
		}

		Arrays.sort(str, new Comparator<String[]>() {    
			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
        
		for (int i = 0; i < N; i++) {
			sb.append(str[i][0] + " " + str[i][1] + "\n");
		}
		System.out.println(sb);
	}
}