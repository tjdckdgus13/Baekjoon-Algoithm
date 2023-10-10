import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[][];
	static int map[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int N;
	static int num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];
		ArrayList<Integer> arr = new ArrayList<Integer>();

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
				visited[i][j] = true;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visited[i][j] == true) {
					num = 1;
					DFS(i, j);
					arr.add(num);

				}
			}
		}

		Collections.sort(arr);

		sb.append(arr.size() + "\n");
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i) + "\n");
		}
		System.out.println(sb);

	}

	static int DFS(int x, int y) {
		visited[x][y] = false;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (map[nx][ny] == 1 && visited[nx][ny] == true) {
					DFS(nx, ny);
					num++;
				}
			}

		}

		return num;
	}
}