import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] clone = arr.clone();
		Arrays.sort(clone);
		Map<Integer, Integer> map = new HashMap<>();

		int num = 0;
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(clone[i])) {
				map.put(clone[i], num++);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(map.get(i) + " ");
		}

		System.out.println(sb.toString());
	}

}
