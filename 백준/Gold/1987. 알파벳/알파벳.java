import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] arr;
    static Map<Character, Integer> map;
    static boolean visit[][];
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        map = new HashMap<>();
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();

            for (int j = 0; j < C; j++) {
                char c = str.charAt(j);
                if (!map.containsKey(c)) {
                    map.put(c, 0);
                }

                arr[i][j] = c;
            }
        }

        map.put(arr[0][0], 1);
        dfs(0, 0, 1);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int n) {

        for (int i = 0; i < 4; i++) {
            int xmove = x + X[i];
            int ymove = y + Y[i];

            if (xmove >= C || xmove < 0 || ymove >= R || ymove < 0 || visit[ymove][xmove]) {
                result = Math.max(result, n);
                continue;
            }

            char c = arr[ymove][xmove];
            if (map.get(c) == 1) {
                result = Math.max(result, n);
                continue;
            }

            visit[ymove][xmove] = true;
            map.put(c, 1);
            dfs(xmove, ymove, n + 1);
            visit[ymove][xmove] = false;
            map.put(c, 0);

        }
    }
}