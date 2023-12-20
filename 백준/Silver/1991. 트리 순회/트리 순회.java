import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Tree tree = new Tree();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();

			tree.create(a, b, c);
		}

		tree.preOrder(tree.tree);
		System.out.println();
		tree.inOrder(tree.tree);
		System.out.println();
		tree.postOrder(tree.tree);

	}
}

class Tree {
	Node tree;

	public void create(String parent, String left, String right) {
		if (tree == null) {
			tree = new Node(parent);
			tree.left = left.equals(".") ? null : new Node(left);
			tree.right = right.equals(".") ? null : new Node(right);
		} else {
			search(tree, parent, left, right);
		}
	}

	public void search(Node node, String parent, String left, String right) {
		if (node == null) {
			return;
		} else if (node.parent.equals(parent)) {
			node.left = left.equals(".") ? null : new Node(left);
			node.right = right.equals(".") ? null : new Node(right);
		} else {
			search(node.left, parent, left, right);
			search(node.right, parent, left, right);
		}
	}

	public void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.parent);
			if (node.left != null)
				preOrder(node.left);
			if (node.right != null)
				preOrder(node.right);
		}
	}

	public void inOrder(Node node) {
		if (node != null) {
			if (node.left != null)
				inOrder(node.left);
			System.out.print(node.parent);
			if (node.right != null)
				inOrder(node.right);
		}
	}

	public void postOrder(Node node) {
		if (node != null) {
			if (node.left != null)
				postOrder(node.left);
			if (node.right != null)
				postOrder(node.right);
			System.out.print(node.parent);
		}
	}
}

class Node {
	String parent;
	Node left, right;

	public Node(String parent) {
		this.parent = parent;
	}

}
