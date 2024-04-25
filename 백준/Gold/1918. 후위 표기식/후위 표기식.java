import java.io.*;
import java.util.*;

public class Main {
    static String[] arr;
    static Stack<String> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        arr = br.readLine().split("");

        solution();

        System.out.println(sb.toString());
    }

    static void solution() {
        for (String string : arr) {
            make(string);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }

    static void make(String str) {
        switch (str) {
            case "+":
            case "-":
            case "*":
            case "/":
                while (!stack.isEmpty() && check(stack.peek()) >= check(str)) {
                    sb.append(stack.pop());
                }
                stack.add(str);
                break;
            case "(":
                stack.add(str);
                break;
            case ")":
                while (!stack.peek().equals("(")) {
                    sb.append(stack.pop());
                }
                stack.pop();
                break;
            default:
                sb.append(str);
                break;
        }
    }

    static int check(String str) {
        if ("*".equals(str) || "/".equals(str)) {
            return 2;
        } else if ("+".equals(str) || "-".equals(str)) {
            return 1;
        } else {
            return 0;
        }
    }
}