import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int[] count;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        count = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            count[b]++;
        }
        bfs();

        System.out.println(sb.toString());
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int curNum = queue.poll();

            sb.append(curNum + " ");

            for (int num : list[curNum]) {
                count[num]--;
                if (count[num] == 0) queue.add(num);
            }
        }
    }

}