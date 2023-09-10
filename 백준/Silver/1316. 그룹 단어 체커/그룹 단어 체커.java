import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		HashSet<Character> set;
		int n = Integer.parseInt(br.readLine());	
		int count = 0;
        
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			set = new HashSet<>();
			boolean b = false;
           
			for (int j = 0; j < str.length(); j++) {  
                
				char a = str.charAt(j);			
				if (j == str.length() - 1) {
					if (set.contains(a))
						b = true;
					break;
				}

				if (a != str.charAt(j + 1)) {
					if (set.contains(a)) {
						b = true;
						break;
					} else {
						set.add(a);
					}
				}
			}
			if (!b)
				count++;
		}
		System.out.println(count);
	}
}
