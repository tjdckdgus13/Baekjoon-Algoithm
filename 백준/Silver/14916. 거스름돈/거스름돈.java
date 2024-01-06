import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = 0;
		while(a>0) {
			if(a%5==0) {
				b += a/5;
				break;
			} 
			a -= 2;
			b++;
			
			if (a<0) {
				b = -1;
				break;
			}
		}
			System.out.println(b);
	}
}
