import java.util.Scanner;

public class Main {
	
	static int[][] dp = new int[30][30];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = 0; i < t ; i++) {
			
			int N = sc.nextInt(); // r
			int M = sc.nextInt(); // n
			
			sb.append(plz(N, M)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int plz(int r, int n) {
		
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		
		if(r == n || r == 0) {
			return dp[n][r] = 1 ;
		}
		
		return dp[n][r] = plz(r-1, n-1 ) + plz(r, n-1);
	}
}
