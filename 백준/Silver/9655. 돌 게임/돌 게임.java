

import java.util.Scanner;

public class Main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] dp = new String[1001];
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		dp[1] = "SK";
		dp[2] = "CY";
		
	
		for (int i = 3; i<=a; i++ ) {
			dp[i]= dp[i-2];
			
			
		}
		System.out.println(dp[a]);
	
	}
}
