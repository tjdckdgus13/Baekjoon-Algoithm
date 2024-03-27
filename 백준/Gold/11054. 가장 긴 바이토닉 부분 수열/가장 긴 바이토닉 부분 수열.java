import java.io.*;
import java.util.*;

public class Main {
    static int[] dpB, dpF, arrB, arrF;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dpB = new int[N];
        dpF = new int[N];
        arrB = new int[N];
        arrF = new int[N];
        check = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        if (N == 1) {
            System.out.println(1);
            System.exit(0);
        }

        for (int i = 0, j = N - 1; i < N; i++, j--) {
            int num = Integer.parseInt(st.nextToken());
            arrF[i] = num;
            arrB[j] = num;
        }
        Arrays.fill(dpB, Integer.MIN_VALUE);
        Arrays.fill(dpF, Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            dfsF(i);
            dfsB(i);
        }

        int max = 0;
        for (int i = 0, j = N - 1; i < N; i++, j--) {
            max = Math.max(dpF[i] + dpB[j], max);
        }

        System.out.println(max - 1);
    }

    public static int dfsF(int N) {
        if (dpF[N] == Integer.MIN_VALUE) {
            dpF[N] = 1;
            for (int i = N - 1; i >= 0; i--) {
                if (arrF[N] > arrF[i]) {
                    dpF[N] = Math.max(dpF[N], dfsF(i) + 1);
                }
            }
        }

        return dpF[N];
    }

    public static int dfsB(int N) {
        if (dpB[N] == Integer.MIN_VALUE) {
            dpB[N] = 1;
            for (int i = N - 1; i >= 0; i--) {
                if (arrB[N] > arrB[i]) {
                    dpB[N] = Math.max(dpB[N], dfsB(i) + 1);
                }
            }
        }

        return dpB[N];
    }
}
