import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			arr = new int[k+1][n+1];
			for (int j = 1; j <= n; j++) {
				arr[0][j] = j;
			}
	
			for (int y = 1; y <= k; y++) {
				for (int x = 1; x <= n; x++) {
					if (x == 1) {
						arr[y][x] = 1;
					} else {
						check(y, x);
					}
				}
			}
			
			sb.append(arr[k][n] + "\n");
		}
		
		System.out.println(sb);
	}
	public static void check(int y, int x) {
		
			int count = 0;
			for (int i = 1; i <=x; i++) {
			count += arr[y-1][i]; 
		}
			arr[y][x] = count;
	}
}