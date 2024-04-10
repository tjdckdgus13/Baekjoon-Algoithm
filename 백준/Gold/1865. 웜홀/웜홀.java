import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] list;
    static int N, M, W;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            ready();
        }

        System.out.println(sb.toString());
    }

    public static void ready() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList();
        }

        for (int i = 0 ; i < M + W; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (i < M) {
                list[a].add(new Node(b, c));
                list[b].add(new Node(a, c));
            } else {
                list[a].add(new Node(b,-c));
            }
        }

        sb.append(bellman() ? "YES" :  "NO").append("\n");
    }

    public static boolean bellman() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean check = false;
        for (int i = 1; i < N; i++) {
            check = false;

            for (int j = 1; j <= N; j++) {
                for (Node node : list[j]) {
                    if (dist[node.end] > dist[j] + node.weight) {
                        dist[node.end] = dist[j] + node.weight;
                        check = true;
                    }
                }
            }
            if (!check) break;
        }

        if (check) {
            for (int i = 1; i <= N; i++) {
                for (Node node : list[i]) {
                    if (dist[node.end] > dist[i] + node.weight) {
                        return true;
                    }
                }
            }
        }

        return false;
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
