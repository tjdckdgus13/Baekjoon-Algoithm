import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] num;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[5][8];
        num = new int[5];

        for (int i = 1; i <= 4; i++) {
            String[] str = br.readLine().split("");
            num[i] = 2;

            for (int j = 0; j < 8; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int gear = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            check = new boolean[5];

            int curLeft = (num[gear] + 4) % 8;
            for (int i = gear; i > 1; i--) {
                if (arr[i][curLeft] == arr[i - 1][num[i - 1]]) break;

                curLeft = (num[i - 1] + 4) % 8;
                check[i - 1] = true;
            }

            int curRight;
            for (int i = gear; i < 4; i++) {
                curRight = (num[i + 1] + 4) % 8;

                if (arr[i][num[i]] == arr[i + 1][curRight]) break;

                check[i + 1] = true;
            }

            leftGear(gear, d);
            rightGear(gear, d);

            if (d == 1) num[gear] = num[gear] - 1 == -1 ? 7 : num[gear] - 1;
            if (d == -1) num[gear] = (num[gear] + 1) % 8;
        }

        int result = 0;
        for (int i = 1; i <= 4; i++) {
            num[i] = num[i] - 2;

            if (num[i] < 0) num[i] = 8 + num[i];

            result += arr[i][num[i]] == 1 ? (int) Math.pow(2, i - 1) : 0;

        }

        System.out.println(result);
    }

    public static void leftGear(int gear, int d) {
        int dire = d;
        for (int i = gear - 1; i >= 1; i--) {
            if (!check[i]) break;

            if (dire == 1) num[i] = (num[i] + 1) % 8;
            if (dire == -1) num[i] = num[i] - 1 == -1 ? 7 : num[i] - 1;

            dire = dire == 1 ? -1 : 1;
        }
    }

    public static void rightGear(int gear, int d) {
        int dire = d;
        for (int i = gear + 1; i <= 4; i++) {
            if (!check[i]) break;

            if (dire == 1) num[i] = (num[i] + 1) % 8;
            if (dire == -1) num[i] = num[i] - 1 == -1 ? 7 : num[i] - 1;

            dire = dire == 1 ? -1 : 1;
        }
    }

}