import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] list;
    static int N, M;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());

        dfs(start);

        System.out.println(dist[finish]);
    }

    public static void dfs(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] check = new boolean[N + 1];

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int a = node.end;

            if (check[a]) continue;

            check[a] = true;

            for (Node i : list[a]) {
                if (dist[i.end] > node.weight + i.weight) {
                    dist[i.end] = node.weight + i.weight;
                    queue.add(new Node(i.end, dist[i.end]));
                }
            }
        }
    }

}

class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}