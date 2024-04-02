import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] dist;
    static Set<String> set;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dist = new int[M];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);

        sb = new StringBuilder();
        for (String i : set) {
            sb.append(i + "\n");
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int depth, int idx) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(dist[i] + " ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = idx; i < N; i++) {
            dist[depth] = arr[i];
            dfs(depth + 1, i);
        }
    }

}