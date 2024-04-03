import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] list;
    static int N, M;
    static boolean[] check;
    static int[] dist, back;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        check = new boolean[N + 1];
        dist = new int[N + 1];
        back = new int[N + 1];
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
        
        Stack<Integer> stack = new Stack<>();
        stack.add(finish);
        while (finish != 0) {
            if (back[finish] == 0) break;

            stack.add(back[finish]);
            finish = back[finish];
        }

        System.out.println(stack.size());

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        
        System.out.println(sb.toString());
    }

    public static void dfs(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int curNode = node.end;
            if (check[curNode]) continue;

            check[curNode] = true;

            for (Node i : list[curNode]) {
                if (dist[i.end] > node.weight + i.weight) {
                    dist[i.end] = node.weight + i.weight;
                    back[i.end] = curNode;
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