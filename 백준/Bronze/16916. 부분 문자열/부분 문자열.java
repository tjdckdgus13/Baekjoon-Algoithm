import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int num = 0;
	static int[] cpi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

	static void kmp(String st, String ptn) {
		int[] pi = cpi(ptn);
		int j = 0;
		for (int i = 0; i < st.length(); i++) {
			while (j > 0 && st.charAt(i) != ptn.charAt(j)) {
				j = pi[j - 1];
			}
			if (st.charAt(i) == ptn.charAt(j)) {
				if (j ==  ptn.length() - 1) {
					num = 1;
					break;
				} else {
					j++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String pat = br.readLine();
        
		kmp(str, pat);
		System.out.println(num);
	}
}
