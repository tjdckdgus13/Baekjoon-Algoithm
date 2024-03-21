import java.util.*;
class Solution {
    static List<Node>[] list;
    public int solution(int n, int s, int a, int b, int[][] fares) {

        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < fares.length; i++) {
            int one = fares[i][0];
            int two = fares[i][1];
            int w = fares[i][2];

            list[one].add(new Node(two, w));
            list[two].add(new Node(one, w));
        }

        int[] A = result(a, n);
        int[] B = result(b, n);
        int[] S = result(s, n);

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(A[i]+B[i] +S[i] , answer);
        }

        return answer;
    }
    
    public static int[] result(int start, int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        queue.add(new Node(start, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;

            if (check[cur]) continue;
            check[cur] = true;

            for (Node i : list[cur]) {
                if (dist[i.end] >  dist[cur] + i.weight) {
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