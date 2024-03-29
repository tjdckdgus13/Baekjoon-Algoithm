import java.io.*;
import java.util.*;

public class Main {
    static int N, M, U, V;
    static List<Node>[] list;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, w));
            list[b].add(new Node(a, w));
        }

        st = new StringTokenizer(br.readLine());

        U = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        sum = 0;
        boolean checkOne = false;
        checkOne = bfs(1, U);
        checkOne = check(check(checkOne, U, V), V, N);
        int answerA = !checkOne ? -1 : sum;

        sum = 0;
        boolean checkTwo = false;
        checkTwo = bfs(1, V);
        checkTwo = check(check(checkTwo, V, U), U, N);
        int answerB = !checkTwo ? -1 : sum;
        
        if (answerA == -1 && answerB == -1) {
            System.out.println(-1);
        } else if (answerA == -1 || answerB == -1) {
            System.out.println(answerA ==  -1 ? answerB : answerA);
        } else {
            System.out.println(Math.min(answerA, answerB));
        }

    }

    public static boolean bfs(int start, int finish) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean[] check = new boolean[N + 1];

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int curNode = node.end;

            if (check[curNode]) continue;

            check[curNode] = true;

            for (Node i : list[curNode]) {
                if (dist[i.end] > node.weight + i.weight) {
                    dist[i.end] = node.weight + i.weight;

                    queue.add(new Node(i.end, dist[i.end]));
                }

            }
        }

        sum += dist[finish];
        return dist[finish] == Integer.MAX_VALUE ? false : true;
    }

    public static boolean check(boolean check, int a, int b) {
        if (!check) {
            sum = -1;
        } else {
            return bfs(a, b);
        }

        return false;
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