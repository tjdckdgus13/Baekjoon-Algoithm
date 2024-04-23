import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R, W;
    static List<Node>[] list;
    static boolean[] check;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            W = 0;
            bfs(i);
            result = Math.max(W, result);
        }

        System.out.println(result);
    }

    static void bfs(int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(n, 0));
        check = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int curNode = node.end;

            if (check[curNode]) continue;

            check[curNode] = true;

            for (Node i : list[curNode]) {
                if (!check[i.end] && dist[i.end] > dist[curNode] + i.weight) {
                    dist[i.end] = dist[curNode] + i.weight;
                    queue.add(new Node(i.end, dist[i.end]));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= M) {
                W += arr[i];
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
        return this.weight - o.weight;
    }
}