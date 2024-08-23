import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = N - 1;
        long zero = Long.MAX_VALUE;
        int a = 0;
        int b = 0;
        while (i < j) {
            long sum = arr[i] + arr[j];
            if (sum == 0) {
                sb.append(arr[i]).append(" ").append(arr[j]);
                System.out.println(sb.toString());
                System.exit(0);
            }

            if (Math.abs(sum) < zero) {
                zero = Math.abs(sum);
                a = i;
                b = j;
            }

            if (sum > 0) {
                j--;
            } else {
                i++;
            }
        }

        sb.append(arr[a]).append(" ").append(arr[b]);
        System.out.println(sb.toString());
    }
}