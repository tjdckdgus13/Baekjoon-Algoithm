import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int A, B, C;
    static boolean[][][] visit;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visit = new boolean[A + 1][B + 1][C + 1];

        dfs(0, 0, C);

        Collections.sort(list);

        for (int i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int x, int y, int z) {
        if (!visit[x][y][z]) {
            visit[x][y][z] = true;
            if (x == 0) {
                list.add(z);
            }

            // A -> B
            if (x + y > B) {
                dfs(x + y - B, B, z);

            } else {
                dfs(0, x + y, z);
            }

            // A -> C
            if (x + z > C) {
                dfs(x + z - C, y, C);

            } else {
                dfs(0, y, x + z);
            }

            // B-> A
            if (y + x > A) {
                dfs(A, y + x - A, z);
            } else {
                dfs(y + x, 0, z);
            }

            // B -> C
            if (y + z > C) {
                dfs(x, y + z - C, C);
            } else {
                dfs(x, 0, y + z);
            }

            // C -> A
            if (z + x > A) {
                dfs(A, y, z + x - A);
            } else {
                dfs(z + x, y, 0);
            }

            // C -> B
            if (z + y > B) {
                dfs(x, B, z + y - B);
            } else {
                dfs(x, z + y, 0);
            }
        }

    }
}
