import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(str.charAt(i));
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}