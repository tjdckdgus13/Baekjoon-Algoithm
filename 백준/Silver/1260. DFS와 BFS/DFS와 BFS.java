import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static boolean check[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}

		check = new boolean[N + 1];
		dfs(V);

		sb.append("\n");

		check = new boolean[N + 1];
		bfs(V);
		
		System.out.println(sb);
	}

	public static void dfs(int V) {
		check[V] = true;
		sb.append(V + " ");
		for (int i = 1; i < map.length; i++) {
			if (map[V][i] == 1 && check[i] == false) {
				dfs(i);
			}
		}
	}

	public static void bfs(int V) {
		Queue<Integer> q = new LinkedList<Integer>();
		check[V] = true;
		q.add(V);
		sb.append(V + " ");
		while (!q.isEmpty()) {
			int tp = q.poll();
			for (int i = 0; i < map.length; i++) {
				if (map[tp][i] == 1 && check[i] == false) {
					q.add(i);
					check[i] = true;
					sb.append(i + " ");
				}
			}
		}
	}

}