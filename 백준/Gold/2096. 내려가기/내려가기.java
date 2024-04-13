import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int N = Integer.parseInt(br.readLine());

        int[] maxArr = new int[3];
        int[] minArr = new int[3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int d = maxArr[0];
            int e = maxArr[2];

            maxArr[0] = Math.max(maxArr[0], maxArr[1]) + a;
            maxArr[2] = Math.max(maxArr[1], maxArr[2]) + c;
            maxArr[1] = Math.max(Math.max(d, e), maxArr[1]) + b;

            int f = minArr[0];
            int g = minArr[2];

            minArr[0] = Math.min(minArr[0], minArr[1]) + a;
            minArr[2] = Math.min(minArr[1], minArr[2]) + c;
            minArr[1] = Math.min(Math.min(f, g), minArr[1]) + b;
        }

        int max = Math.max(Math.max(maxArr[0], maxArr[1]), maxArr[2]);
        int min = Math.min(Math.min(minArr[0], minArr[1]), minArr[2]);

        System.out.println(max + " " + min);
    }
}

