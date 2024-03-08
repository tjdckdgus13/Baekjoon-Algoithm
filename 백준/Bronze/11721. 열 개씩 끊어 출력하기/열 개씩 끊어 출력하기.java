import org.w3c.dom.Node;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        int n = str.length() / 10;

        int idx = 0;
        for (int i  =0; i < n; i++) {
            sb.append(str.substring(idx, idx + 10) + "\n");
            idx += 10;
        }

        sb.append(str.substring(str.length() - (str.length() % 10))).append("\n");

        System.out.println(sb.toString());
    }
}





