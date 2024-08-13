import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            List<Node> list = new ArrayList<>();

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Node(a, b));
            }

            Collections.sort(list);
            
            int count = 1;
            int min = list.get(0).b;
            for (int i = 1; i < N; i++) {
                Node node = list.get(i);

                if (node.b > min) continue;

                min = node.b;
                count++;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
    }
}

class Node implements Comparable<Node> {
    int a;
    int b;

    public Node(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Node o) {
        return this.a - o.a;
    }
}