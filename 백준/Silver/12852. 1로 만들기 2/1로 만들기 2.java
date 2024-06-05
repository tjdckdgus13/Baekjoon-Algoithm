import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N+1];
        int[] S = new int[N+1];

        for (int i = 2; i <= N; i++) {
            D[i] = D[i-1] + 1;
            S[i] = i-1;
            if (i % 2 == 0 && D[i] > D[i/2] + 1) {
                D[i] = D[i/2] + 1;
                S[i] = i/2;
            }
            if (i % 3 == 0 && D[i] > D[i/3] + 1) {
                D[i] = D[i/3] + 1;
                S[i] = i/3;
            }
        }

        System.out.println(D[N]);
        do {
            sb.append(N + " ");
            N = S[N];
        } while (N != 0);
        System.out.print(sb);
    }
}