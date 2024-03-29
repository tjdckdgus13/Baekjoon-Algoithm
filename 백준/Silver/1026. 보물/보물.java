import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        int[] b = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int result = 0;
        for (int i = 0, j = N - 1; i < N; i++, j--) {
            result += a[i] * b[j];
        }

        System.out.println(result);
    }
}