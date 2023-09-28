import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		
		int[] g = new int[1001];
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 후보 수 
		int d = sc.nextInt(); // 다솜이 투표 수
		
		for (int i = 0; i < n-1; i++) {
			g[i] = sc.nextInt();
		}
		
		int num = 0; // 필요한 최소 득표 수 
		
		while(true) {
			Arrays.sort(g);
			if(d <= g[g.length-1]) {
				
				d++;
				g[g.length-1]--;
				
				num++;
			} else {
				System.out.println(num);
				break;
			}
		}
		
	
		
		
	
	}
}
