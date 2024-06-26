import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            if (st.nextToken().equals("1")) arr[i] = true;
        }

        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                man(num);
            } else {
                girl(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i] ? 1 : 0).append(" ");

            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static void man(int num) {
        int a = num;
        while (N >= a) {
            arr[a] = !arr[a] ? true : false;

            a += num;
        }
    }

    static void girl(int num) {
        int i = num - 1;
        int j = num + 1;
        arr[num] = !arr[num] ? true : false;
        while (i > 0 && j <= N) {
            if (arr[i] == arr[j]) {
                arr[i] = !arr[i] ? true : false;
                arr[j] = arr[i];
            } else {
                break;
            }
            i--;
            j++;
        }
    }
}