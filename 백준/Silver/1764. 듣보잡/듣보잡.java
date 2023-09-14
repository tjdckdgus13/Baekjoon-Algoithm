import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> map = new HashMap<String,String>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map.put(str, str);
		}
		ArrayList<String> arr = new ArrayList<String>();
		int count = 0;
		for(int i = 0; i <M; i++) {
			String str = br.readLine();
			if(map.containsKey(str)) {
				count++;
				arr.add(str);
			}
		}
		Collections.sort(arr);
		for (String s : arr) {
			sb.append(s + "\n");
		}
		System.out.println(count);
		System.out.println(sb);
	}
}