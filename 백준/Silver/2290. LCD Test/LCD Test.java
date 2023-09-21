import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int s;
	static StringBuilder sb[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		s = Integer.parseInt(st.nextToken());
		sb = new StringBuilder[2 * s + 3];
		for (int i = 0; i < 2 * s + 3; i++) {
			sb[i] = new StringBuilder();
		}
		String n = st.nextToken();

		for (int i = 0; i < n.length(); i++) {
			switch (n.charAt(i)) {
			case '1':
				upper1();
				upmiddle2();
				middle1();
				downmiddle2();
				down1();
				break;
			case '2':
				upper2();
				upmiddle2();
				middle2();
				downmiddle1();
				down2();
				break;
			case '3':
				upper2();
				upmiddle2();
				middle2();
				downmiddle2();
				down2();
				break;
			case '4':
				upper1();
				upmiddle3();
				middle2();
				downmiddle2();
				down1();
				break;
			case '5':
				upper2();
				upmiddle1();
				middle2();
				downmiddle2();
				down2();
				break;
			case '6':
				upper2();
				upmiddle1();
				middle2();
				downmiddle3();
				down2();
				break;
			case '7':
				upper2();
				upmiddle2();
				middle1();
				downmiddle2();
				down1();
				break;
			case '8':
				upper2();
				upmiddle3();
				middle2();
				downmiddle3();
				down2();
				break;
			case '9':
				upper2();
				upmiddle3();
				middle2();
				downmiddle2();
				down2();
				break;
			case '0':
				upper2();
				upmiddle3();
				middle1();
				downmiddle3();
				down2();
				break;
			}
			for(int j = 0; j < sb.length; j++) {
				sb[j].append(' ');
			}

		}

		for (int i = 0; i < sb.length; i++) {
			System.out.println(sb[i]);
		}
	}

	public static void upper1() {
		for (int i = 0; i < s + 2; i++) {
			sb[0].append(' ');
		}

	}

	public static void upper2() {
		sb[0].append(' ');
		for (int i = 0; i < s; i++) {
			sb[0].append('-');
		}
		sb[0].append(' ');
	}

	public static void upmiddle1() {
		for (int i = 1; i < s + 1; i++) {
			sb[i].append('|');
			for (int j = 0; j < s + 1; j++) {
				sb[i].append(' ');
			}
		}
	}

	public static void upmiddle2() {
		for (int i = 1; i < s + 1 ; i++) {
			for (int j = 0; j < s + 1; j++) {
				sb[i].append(' ');
			}
			sb[i].append('|');
		}
	}

	public static void upmiddle3() {
		for (int i = 1; i < s + 1; i++) {
			sb[i].append('|');
			for (int j = 0; j < s; j++) {
				sb[i].append(' ');
			}
			sb[i].append('|');
		}
	}

	public static void middle1() {
		for (int i = 0; i < s+2; i++) {
			sb[s + 1].append(' ');
		}
	}

	public static void middle2() {
		sb[s + 1].append(' ');
		for (int i = 0; i < s; i++) {
			sb[s + 1].append('-');
		}
		sb[s + 1].append(' ');
	}

	public static void downmiddle1() {
		for (int i = s + 2; i < 2 * s + 2; i++) {
			sb[i].append('|');
			for (int j = 0; j < s + 1; j++) {
				sb[i].append(' ');
			}
		}
	}

	public static void downmiddle2() {
		for (int i = s + 2; i < s * 2 + 2; i++) {
			for (int j = 0; j < s + 1; j++) {
				sb[i].append(' ');
			}
			sb[i].append('|');
		}
	}

	public static void downmiddle3() {
		for (int i = s + 2; i < s * 2 + 2; i++) {
			sb[i].append('|');
			for (int j = 0; j < s; j++) {
				sb[i].append(' ');
			}
			sb[i].append('|');
		}
	}

	public static void down1() {
		for (int i = 0; i < s + 2; i++) {
			sb[s * 2 + 2].append(' ');
		}
	}

	public static void down2() {
		sb[s * 2 + 2].append(' ');
		for (int i = 0; i < s; i++) {
			sb[s * 2 + 2].append('-');
		}
		sb[s * 2 + 2].append(' ');
	}
}