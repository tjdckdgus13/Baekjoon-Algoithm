import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int result = 0;
	    for (int i = 0; i <5 ; i++) {
	        int a = Integer.parseInt(br.readLine());
	        if (a < 40) {
	            result += 40;
	        } else {
	            result += a;
	        }
	    }
	    
	    System.out.println(result/5);
	}
}