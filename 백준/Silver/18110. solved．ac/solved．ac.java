import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(sc.readLine());
            int result = 0;

            if (N == 0) {
                System.out.println(result);
                System.exit(0);
            }

            int[] score = new int[N];
            
            for (int i = 0; i < N; i++) {
                score[i] = Integer.parseInt(sc.readLine());
            }
            
            Arrays.sort(score);

            BigDecimal a = new BigDecimal(N);
            
            BigDecimal percentage_15 = new BigDecimal("0.15");
			BigDecimal value = a.multiply(percentage_15); 
			value=value.setScale(0, RoundingMode.HALF_UP);
			int roundvalue = value.intValue();

			BigDecimal sum=new BigDecimal("0");
			
			for(int i=roundvalue;i<N-roundvalue;i++){
				sum=sum.add(new BigDecimal(score[i]));
			}
			
			if(N - (roundvalue * 2) != 0){
				sum=sum.divide(new BigDecimal(N - (roundvalue * 2)), RoundingMode.HALF_UP);
				
				result=sum.intValue();
				System.out.println(result);
				
       		} else{
            	System.out.println(0); // If there are no valid votes left after trimming, print out zero.
        	}
        } catch(Exception e) {
           e.printStackTrace();
        }
    }
}