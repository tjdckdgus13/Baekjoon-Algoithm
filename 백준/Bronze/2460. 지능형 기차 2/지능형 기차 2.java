import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int IN = 0;
		int OUT = 0;
		int SUM = 0;
		int MAX = 0;
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			SUM -= OUT = Integer.parseInt(st.nextToken());
			SUM += IN = Integer.parseInt(st.nextToken());
			
			if(SUM > MAX ) MAX = SUM;
		}	
		System.out.println(MAX);
	}

}
