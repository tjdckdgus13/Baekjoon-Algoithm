import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Node>[] list;
    static int[] result;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(br.readLine());

        list = new ArrayList[u + 1];
        result = new int[u + 1];
        visit = new boolean[u + 1];

        for (int i = 1; i <= u; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));

        }

        pq(w);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= u; i++) {
            if (Integer.MAX_VALUE == result[i]) {
                sb.append("INF" + "\n");
                continue;
            }

            sb.append(result[i] + "\n");
        }

        System.out.println(sb.toString());
    }

    public static void pq(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        Arrays.fill(result, Integer.MAX_VALUE);

        result[start] = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;

            if (visit[cur]) continue;
            visit[cur] = true;

            for (Node node : list[cur]) {
                if (result[node.end] > node.weight + curNode.weight) {
                    result[node.end] = node.weight + curNode.weight;
                    queue.add(new Node(node.end, result[node.end]));
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
        return this.weight - o.weight;
    }
}