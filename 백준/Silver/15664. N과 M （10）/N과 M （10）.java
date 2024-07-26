import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, M;
    static int[] dist;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dist = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        back(0, 0);

        StringBuilder sb = new StringBuilder();
        for (String str : set) {
            sb.append(str).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void back(int dep, int idx) {
        if (M == dep) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(dist[i]).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = idx; i < N; i++) {
            dist[dep] = arr[i];
            back(dep + 1, i + 1);
        }
    }
}