import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] visit;
    static int result[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        result = new int[N + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i < result.length; i++) {
            sb.append(result[i] + "\n");
        }

        System.out.println(sb.toString());

    }

    public static void dfs (int idx) {
        visit[idx] = true;
        for (int i : list[idx]) {
            if (!visit[i]) {
                result[i] = idx;
                dfs(i);
            }
        }
    }
}


