import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node>[] list;
    static boolean[] check;
    static int max = 0;
    static int max_n = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) break;
                int w = Integer.parseInt(st.nextToken());

                list[a].add(new Node(b, w));
                list[b].add(new Node(a,w));
            }
        }

        check[1] = true;
        dfs(1,0);

        check = new boolean[N + 1];
        check[max_n] = true;
        dfs(max_n, 0);

        System.out.println(max);

    }

    public static void dfs (int end, int w) {
        if (max < w) {
            max = w;
            max_n = end;
        }

        for (Node i : list[end]) {
            if (check[i.end]) continue;

            check[i.end] = true;
            dfs(i.end, i.weight + w);
        }
    }
}

class Node {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}