import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        String[] result = new String[T];
        
        for(int i=0; i<T; i++) {
            String S = sc.next();
            result[i] = String.valueOf(S.charAt(0)) + String.valueOf(S.charAt(S.length()-1));
        }
        
        for(int j=0; j<T; j++) {
			System.out.println(result[j]);
		}
    }
}