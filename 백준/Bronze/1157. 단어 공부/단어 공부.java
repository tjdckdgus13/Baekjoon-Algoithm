import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String str = br.readLine();
		str = str.toLowerCase();
		int count = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
			count = Math.max(count, map.get(str.charAt(i)));
		}
        
		boolean bl = false;
		String result = "";
		for (Map.Entry<Character, Integer> i : map.entrySet()) {
			if (i.getValue() == count) {
				if (!bl) {
					result = "" + i.getKey();
					bl = true;
				} else {
					result = "?";
					break;
				}
			}
		}
		System.out.println(result.toUpperCase());
	}
}
