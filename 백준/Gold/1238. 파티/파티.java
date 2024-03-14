import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] check;
    static ArrayList<Node>[] frontList, backList;
    static int N, M, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        frontList = new ArrayList[N + 1];
        backList = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            frontList[i] = new ArrayList<Node>();
            backList[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            frontList[n].add(new Node(m, w));
            backList[m].add(new Node(n, w));
        }

        int[] front = bfs(frontList);
        int[] back = bfs(backList);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, front[i] + back[i]);
        }

        System.out.println(max);
    }

    public static int[] bfs(ArrayList<Node>[] list) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(X, 0));

        check = new boolean[N + 1];
        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[X] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;

            if (check[cur]) continue;

            check[cur] = true;

            for (Node i : list[cur]) {
                if (dist[i.end] > dist[cur] + i.weight) {
                    dist[i.end] = dist[cur] + i.weight;
                    queue.add(new Node(i.end, dist[i.end]));
                }
            }
        }
        
        return dist;
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