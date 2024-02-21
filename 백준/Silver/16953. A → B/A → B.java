import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int start, end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { start, 1 });

		int result = -1;
		while (!queue.isEmpty()) {

			int[] arr = queue.poll();

			if (arr[0] == end) {
				result = arr[1];
				break;
			}

			if ((long) arr[0] * 2 <= end)
				queue.add(new int[] { arr[0] * 2, arr[1] + 1 });

			if ((long) arr[0] * 10 + 1 <= end)
				queue.add(new int[] { arr[0] * 10 + 1, arr[1] + 1 });
		}

		return result;
	}
}
