import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

	Queue<Integer> q = new LinkedList<Integer>();	
	Scanner sc = new Scanner(System.in);
	
	int n = sc.nextInt();
	int k = sc.nextInt();
	for(int i = 1; i<= n; i++) {
		q.offer(i);
	}
	
	StringBuilder sb = new StringBuilder();
	
	sb.append("<");
	
	while(q.size()>1) {
		for(int i = 0 ; i<k-1; i++ ) {
			q.offer(q.poll());
		}
		

		sb.append(q.poll()+", ");
	}
	sb.append(q.poll());
	sb.append(">");
	
	System.out.println(sb);
	}
}
