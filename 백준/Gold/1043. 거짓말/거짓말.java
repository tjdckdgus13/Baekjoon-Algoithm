import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static Map<Integer, Integer> map;
    static List<Integer>[] list;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());

        if (K == 0) {
            System.out.println(M);
            System.exit(0);
        }

        map = new HashMap<>();
        while (st.hasMoreTokens()) {
            map.put(Integer.parseInt(st.nextToken()), 0);
        }

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        list = new ArrayList[M];

        for (int i = 0; i < M; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            st.nextToken();

            while (st.hasMoreTokens()) list[i].add(Integer.parseInt(st.nextToken()));
        }

        solution();

        int count = 0;
        for (int i = 0; i < M; i++) {
            boolean check = false;
            for (int num : list[i]) {
                int a = find(num);
                if (map.containsKey(a)) {
                    check = true;
                    break;
                }
            }

            if (!check) count++;
        }
        
        System.out.println(count);
    }

    static void solution() {
        for (int i = 0; i < M; i++) {
            int first = list[i].get(0);
            for (int j = 1; j < list[i].size(); j++) {
                int x = find(first);
                int y = find(list[i].get(j));
                if (map.containsKey(y)) {
                    int temp = y;
                    y = x;
                    x = temp;
                }

                arr[y] = x;
            }
        }
    }

    static int find(int x) {
        if (arr[x] == x) return x;
        return find(arr[x]);
    }
}