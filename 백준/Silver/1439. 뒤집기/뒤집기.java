import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] str = sc.nextLine().split("");

		int a = 0;
		int b = 0;
		
		if(str[0].equals("0")) {
			a++;
		} else {
			b++;
		}
		
		for(int i = 1; i<str.length; i++) {
			if(!str[i].equals(str[i-1])) {
					if(str[i].equals("0")) {
						a++;
					}else {
						b++;
					}
			}
		}
		
		if(a>=b) {
			System.out.println(b);
		} else {
			System.out.println(a);
		}
	}
}
