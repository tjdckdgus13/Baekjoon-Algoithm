import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            arr = br.readLine().toCharArray();
            sb.append(recursion(0, arr.length - 1, 0)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int recursion(int start, int end, int count) {
        if (count >= 2) return 2;

        while (start < end) {
            if (arr[start] == arr[end]) {
                start++;
                end--;
            } else {
                return Math.min(recursion(start + 1, end, count + 1), recursion(start, end - 1, count + 1));
            }
        }

        return count;
    }

}
