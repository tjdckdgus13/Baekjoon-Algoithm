import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count, curTime;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        curTime = Integer.MAX_VALUE;
        count = 0;
        visit = new int[100001];

        if (N == M) {
            System.out.println(0);
            System.out.println(1);
            System.exit(0);
        }

        bfs();

        System.out.println(curTime);
        System.out.println(count);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));
        Arrays.fill(visit, Integer.MAX_VALUE);
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int num = node.num;
            int time = node.time;

            if (num == M) {
                if (time < curTime) {
                    count = 1;
                    curTime = time;
                } else if (time == curTime) {
                    count++;
                }
            }

            if (num + 1 < 100001 && visit[num + 1] >= time + 1) {
                queue.add(new Node(num + 1, time + 1));
                visit[num + 1] = time + 1;
            }

            if (num - 1 >= 0 && visit[num - 1] >= time + 1) {
                queue.add(new Node(num - 1, time + 1));
                visit[num - 1] = time + 1;
            }

            if (num * 2 < 100001 && visit[num * 2] >= time + 1) {
                queue.add(new Node(num * 2, time + 1));
                visit[num * 2] = time + 1;
            }
        }
    }
}

class Node {
    int num;
    int time;

    public Node(int num, int time) {
        this.num = num;
        this.time = time;
    }
}