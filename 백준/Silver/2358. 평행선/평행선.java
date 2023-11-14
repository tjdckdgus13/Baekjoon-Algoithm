import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		HashMap<Integer, ArrayList<Integer>> x = new HashMap<Integer, ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> y = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i = 0; i<n; i++) {
			String[] str = bf.readLine().split(" ");
			int xx = Integer.parseInt(str[0]);
			int yy = Integer.parseInt(str[1]);
			
			ArrayList<Integer> xList =new ArrayList<Integer>();
			ArrayList<Integer> yList =new ArrayList<Integer>();
			
			if(x.containsKey(xx)) {
				yList = x.get(xx);
			}
			yList.add(yy);
			x.put(xx, yList);
			
			if(y.containsKey(yy)) {
				xList = y.get(yy);
			}
			xList.add(xx);
			y.put(yy, xList);
		}

		int num = 0;
		for(int key : x.keySet()) {
			if(x.get(key).size() >= 2) {
				num++;
			}
		}
		
		for(int key  : y.keySet()) {
			if(y.get(key).size() >= 2) {
				num++;
			}
		}	
		System.out.println(num);
	}
}
