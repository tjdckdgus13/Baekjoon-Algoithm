import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		char[][] arr = new char[h][w];

		for (int i = 0; i < h; i++) {
			String str = bf.readLine();
			for (int j = 0; j < w; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int num = 0;
		for (int i = 0; i < h; i++) {
			num = 0;
			for (int j = 0; j < w; j++) {

				if (arr[i][j] == 'c') {
					num = 1;
					sb.append("0 ");
				} else if (arr[i][j] == '.') {
					if (num == 0) {
						sb.append("-1 ");
					} else {
						sb.append(num + " ");
						num++;
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
