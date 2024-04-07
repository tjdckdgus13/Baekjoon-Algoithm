import java.io.*;

public class Main {
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().split(" ");
        int num = Integer.parseInt(arr[0]);
        if (num == 1) {
            System.out.println(up() ? "ascending" : "mixed");
        } else {
            System.out.println(down() ? "descending" : "mixed");
        }
    }

    public static boolean up() {
        for (int i = 0, j = 1; i < 8; i++, j++) {
            if (Integer.parseInt(arr[i]) == j) continue;

            return false;
        }

        return true;
    }

    public static boolean down() {
        for (int i = 0, j = 8; i < 8; i++, j--) {
            if (Integer.parseInt(arr[i]) == j) continue;

            return false;
        }

        return true;
    }

}