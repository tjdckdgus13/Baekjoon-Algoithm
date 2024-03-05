import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static Set<String> set = new LinkedHashSet<>();
    static int N, M;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        check(0, 0);

        StringBuilder sb = new StringBuilder();
        for (String i : set) {
            sb.append(i+ "\n");
        }

        System.out.println(sb.toString());

    }

    public static void check (int depth, int idx){
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(result[i] + " ");
            }

            set.add(sb.toString());
            return;
        }

        for (int i = idx; i < N; i++) {
            result[depth] = arr[i];
            check(depth + 1 , i);
        }
    }
}

