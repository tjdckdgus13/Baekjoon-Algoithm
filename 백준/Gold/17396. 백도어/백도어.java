import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Node>[] list;
    static boolean[] visit;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) visit[i] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }

        dijkstra();

        System.out.println(dist[N - 1] == Long.MAX_VALUE ? -1 : dist[N - 1]);
    }

    static void dijkstra() {
        dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int end = node.end;

            if (visit[end]) continue;
            visit[end] = true;

            for (Node i : list[end]) {
                if (i.weight + node.weight < dist[i.end]) {
                    dist[i.end] = i.weight + node.weight;
                    queue.add(new Node(i.end, dist[i.end]));
                }
            }

        }
    }
}

class Node implements Comparable<Node> {
    int end;
    long weight;

    public Node(int end, long weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight > 0 ? 1 : -1;
    }
}