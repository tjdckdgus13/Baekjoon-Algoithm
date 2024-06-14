import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 1; i <= 8; i++) {
            int n = Integer.parseInt(br.readLine());
            queue.add(new Node(n, i));
        }

        int sum = 0;
        int[] arr = new int[5];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            Node node = queue.poll();

            sum += node.num;
            arr[i] = node.idx;
        }

        Arrays.sort(arr);
        for (int i : arr) {
            sb.append(i + " ");
        }

        System.out.println(sum);
        System.out.println(sb.toString());
    }
}

class Node implements Comparable<Node> {
    int num;
    int idx;

    public Node(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    @Override
    public int compareTo(Node o) {
        return o.num - this.num;
    }
}