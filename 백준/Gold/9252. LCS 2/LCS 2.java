import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");

        int length1 = str1.length;
        int length2 = str2.length;

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1[i - 1].equals(str2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        int x = length1;
        int y = length2;
        StringBuilder sb = new StringBuilder();
        while (x > 0 && y > 0) {

            if (dp[x - 1][y] == dp[x][y]) {
                x--;
            } else if (dp[x][y - 1] == dp[x][y]) {
                y--;
            } else {
                sb.append(str1[x - 1]);
                x--;
                y--;
            }
        }
        System.out.println(dp[length1][length2]);
        System.out.println(sb.reverse().toString());
    }
}