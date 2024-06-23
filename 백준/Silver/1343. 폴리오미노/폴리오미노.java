import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static int N;
	public static char[] map;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	map = st.nextToken().toCharArray();
    	for(int i=0;i<map.length;i++) {
    		 if( i+3 <=  map.length -1 ) {
	    		if(map[i] == 'X' && map[i+1] == 'X' && map[i+2] == 'X' && map[i+3] == 'X') {
	    			map[i] = 'A';
	    			map[i+1] = 'A';
	    			map[i+2] = 'A';
	    			map[i+3] = 'A';
	    		}    			 
    		 }
    		 
    		 if( i + 1 <= map.length - 1) {
    			 if(map[i] == 'X' && map[i+1] == 'X') {
 	    			map[i] = 'B';
 	    			map[i+1] = 'B';
 	    		} 
    		 }
    	}
    	
    	for(char value:map) {
    		if(value == 'X') {
    			System.out.println("-1");
    			return;
    		}
    		
    	}
    	for(char value:map) {
    		System.out.print(value);
    	}
    }
}