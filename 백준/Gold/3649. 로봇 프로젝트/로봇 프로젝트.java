import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int X;
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            while (true) {
                X = Integer.parseInt(br.readLine()) * 10000000;
                N = Integer.parseInt(br.readLine());

                arr = new int[N];
                for (int i = 0; i < N; i++) {
                    arr[i] = Integer.parseInt(br.readLine());
                }

                Arrays.sort(arr);

                tp();

                sb.append("\n");
            }
        } catch (Exception e) {
            System.out.println(sb.toString());
        }

    }

    static void tp() {
        int end = N - 1;
        int a = 0;
        int b = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; ) {
            if (i >= end) break;

            int sum = arr[i] + arr[end];

            if (sum == X) {
                if (Math.abs(arr[i] - arr[end]) > max) {
                    max = Math.abs(arr[i] - arr[end]);
                    a = arr[i];
                    b = arr[end];
                }
                i++;
                end--;
                continue;
            }

            if (sum > X) {
                end--;
            } else {
                i++;
            }
        }

        sb.append(max == Integer.MIN_VALUE ? "danger" : "yes " + a + " " + b);
    }
}