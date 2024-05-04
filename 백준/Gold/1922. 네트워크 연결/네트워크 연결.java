import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] list;
    static int N, M;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
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

        int sum = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;
            int w = curNode.weight;

            if (visit[cur]) continue;

            visit[cur] = true;
            sum += w;
            count++;

            if (count == N) break;

            for (Node node : list[cur]) {
                if (!visit[node.end]) {
                    queue.add(node);
                }
            }
        }

        return sum;
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