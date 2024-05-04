import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int N, M;
    static PriorityQueue<Node> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        make();

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            queue.add(new Node(a, b, c));
        }

        System.out.println(bfs());
    }

    static int bfs() {
        int sum = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int start = node.start;
            int end = node.end;
            int w = node.weight;

            if (union(start, end)) {
                sum += w;
            }

        }

        return sum;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int X = find(x);
        int Y = find(y);

        if (X == Y) return false;
        else {
            parent[Y] = X;
            return true;
        }
    }

    static void make() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

}

class Node implements Comparable<Node> {
    int start;
    int end;
    int weight;

    public Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}