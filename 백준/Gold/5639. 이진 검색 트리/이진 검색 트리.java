import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        Node node = new Node(Integer.parseInt(br.readLine()));

        while (true) {
            String str = br.readLine();
            if (str == null || str.equals("")) {
                break;
            }

            node.insert(Integer.parseInt(str));
        }

        postorder(node);

        System.out.println(sb.toString());
    }

    static void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        sb.append(node.node).append("\n");
    }
}

class Node {
    int node;
    Node left;
    Node right;

    Node(int node) {
        this.node = node;
    }

    void insert(int num) {
        if (node > num) {
            if (left == null) left = new Node(num);
            else left.insert(num);
        } else {
            if (right == null) right = new Node(num);
            else right.insert(num);
        }
    }
}