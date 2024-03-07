import org.w3c.dom.Node;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i <= 8; i++) {
            map.put(String.valueOf(i), 0);
        }

        for (int i = 0 ; i < str.length(); i++) {
            String a = String.valueOf(str.charAt(i));
            if (a.equals("9")) {
                map.put("6", map.get("6") + 1);
                continue;
            }

            map.put(a, map.get(a) + 1);
        }

        int result = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> i : map.entrySet()){
            if (i.getValue() == 0)
                continue;

            if (i.getKey().equals( "6")) {
                result = Math.max(i.getValue() % 2 == 0 ? i.getValue() / 2 : i.getValue() /2 + 1 , result);
                continue;
            }

            result = Math.max(result , i.getValue());

        }

        System.out.println(result == Integer.MIN_VALUE ? 0 : result );

    }
}





