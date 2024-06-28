import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int startX, startY, finishX, finishY, N;
    static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Node(x, y));
            }

            st = new StringTokenizer(br.readLine());

            finishX = Integer.parseInt(st.nextToken());
            finishY = Integer.parseInt(st.nextToken());

            sb.append(!bfs() ? "sad" : "happy").append("\n");
        }

        System.out.println(sb.toString());
    }

    public static boolean bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        boolean[] check = new boolean[N];
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            if (Math.abs(x - finishX) + Math.abs(y - finishY) <= 1000) return true;

            for (int i = 0; i < N; i++) {
                if (check[i]) continue;

                int xmove = list.get(i).x;
                int ymove = list.get(i).y;

                if (Math.abs(x - xmove) + Math.abs(y - ymove) <= 1000) {
                    queue.add(list.get(i));
                    check[i] = true;
                }
            }
        }
        
        return false;
    }
    
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}