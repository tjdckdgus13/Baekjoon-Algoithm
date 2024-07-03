import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;

        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];

            if (Math.abs(sum) < min) {
               min = Math.abs(sum);

               a = arr[start];
               b = arr[end];

               if(sum == 0) break;
            }

           if (sum > 0) end--;
           else start++;
        }

        System.out.println(a + " " + b);
    }

}