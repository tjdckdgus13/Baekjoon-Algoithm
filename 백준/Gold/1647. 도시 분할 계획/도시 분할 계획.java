import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<Node>[] list;
    static boolean[] visit;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        System.out.println(bfs());
    }

    static int bfs() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));

        int w = 0;
        int sum = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int end = node.end;
            int weight = node.weight;

            if (visit[end]) continue;

            visit[end] = true;
            sum += weight;
            w = Math.max(w, weight);
            count++;

            if (count == N) break;

                for (Node i : list[end]) {
                    if (!visit[i.end]) {
                        queue.add(new Node(i.end, i.weight));
                    }
                }
        }
        
        return sum - w;
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