import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int a;
	static int v, x, y;
	static int[] vx = { 0, -1, 0, 1 };
	static int[] vy = { 1, 0, -1, 0 };
	static int minX, minY, maxX, maxY;
	static char[] ch;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		a = Integer.parseInt(br.readLine());
		for (int i = 0; i < a; i++) {
            
			ch =br.readLine().toCharArray();
			v = 0;
			x = 0;
			y = 0;
			maxX = 0;
			minX = 0;
			maxY = 0;
			minY = 0;		
			for (int j = 0; j < ch.length; j++) {

				switch (ch[j]) {
				case 'L':
					if (v + 1 == 4) {
						v = 0;
					} else {
						v += 1;
					}
					break;
				case 'R':
					if (v - 1 == -1) {
						v = 3;
					} else {
						v -= 1;
					}
					break;
				case 'F':
					x += vx[v];
					y += vy[v];
					now();
					break;
				case 'B':
					x -= vx[v];
					y -= vy[v];
					now();
					break;

				}
			}

			if(((maxX - minX) * (maxY - minY)) >= 0) {
				System.out.println(((maxX - minX) * (maxY - minY)));
			} else {
				System.out.println(-((maxX - minX) * (maxY - minY)));
			}
		}
	}

	static void now() {
		maxX = Math.max(maxX, x);
		minX = Math.min(minX, x);
		maxY = Math.max(maxY, y);
		minY = Math.min(minY, y);
	}
}
