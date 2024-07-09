import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(num, start, end));
        }
        
        Collections.sort(list);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (queue.isEmpty()) {
                queue.add(list.get(i).end);
            } else {
                if (queue.peek() > list.get(i).start) {
                    queue.add(list.get(i).end);
                } else {
                    queue.add(list.get(i).end);
                    queue.poll();
                }
            }
        }

        System.out.println(queue.size());
    }

}

class Node implements Comparable<Node> {

    int num;
    int start;
    int end;

    public Node(int num, int start, int end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node o) {
        return this.start - o.start;
    }
}