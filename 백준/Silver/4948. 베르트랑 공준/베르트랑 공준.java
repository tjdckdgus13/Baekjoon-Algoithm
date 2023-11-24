import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] bl = new boolean[(123456 * 2) + 1];

		for (int i = 2; i <= Math.sqrt(246912); i++) {
			if (!bl[i]) {
				for (int j = i * i; j <= 246912; j += i) {
					bl[j] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;

			int count = 0;
			for (int i = N + 1; i <= N * 2; i++) {
				if (!bl[i])
					count++;
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
}
