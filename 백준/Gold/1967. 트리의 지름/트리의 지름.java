import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node>[] list;
    static int N;
    static int max = 0;
    static int max_n = 0;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, w));
            list[b].add(new Node(a, w));
        }

        check[1] = true;
        dfs(1, 0);

        check = new boolean[N + 1];
        check[max_n] = true;
        dfs(max_n, 0);

        System.out.println(max);
    }

    public static void dfs(int end, int w) {
        if (max < w) {
            max = w;
            max_n = end;
        }

        for (Node i : list[end]) {
            if (check[i.end]) continue;

            check[i.end] = true;
            dfs(i.end, w + i.w);
            check[i.end] = false;
        }
    }
}

class Node {
    int end;
    int w;

    public Node(int end, int w) {
        this.end = end;
        this.w = w;
    }
}