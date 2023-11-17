import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<String> hs = new HashSet<String>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			hs.add(br.readLine());
		}
        
		ArrayList<String> arr = new ArrayList<String>(hs);
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length())
					return 1;
				else if (o1.length()==o2.length())
					return o1.compareTo(o2);
				else
					return -1;
			}
		});

		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i) + '\n');
		}
		System.out.println(sb);
	}
}