import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int N, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        dfs(0);

        System.out.println(count);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i< N; i++) {
            arr[depth] = i;

            if (check(depth)) {
                dfs(depth + 1);
            }
        }

    }

    public static boolean check (int depth) {

        for (int i = 0; i < depth; i++) {

            if (arr[i] == arr[depth]) {
                return false;
            }

            if (Math.abs(depth - i) == Math.abs(arr[i] - arr[depth])) {
                return false;
            }
        }

        return true;
    }
}

