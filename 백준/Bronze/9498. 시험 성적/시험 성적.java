import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());

		if (100 >= a && a >= 90) {
			System.out.println("A");
		} else if (89 >= a && a >= 80) {
			System.out.println("B");
		} else if (79 >= a && a >= 70) {
			System.out.println("C");
		} else if (69 >= a && a >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}
}