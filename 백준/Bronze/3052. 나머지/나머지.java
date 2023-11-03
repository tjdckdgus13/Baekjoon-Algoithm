import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10; i++) {
			int a = Integer.parseInt(br.readLine());
			map.put(a%42, +1);
		}	
		System.out.println(map.size());
	}
}