import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayDeque<Node> stack = new ArrayDeque<>();
    private static int n;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Node(number, i + 1));
            } else {
                while (!stack.isEmpty() && stack.peek().number < number) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    sb.append("0 ");
                    stack.push(new Node(number, i + 1));
                } else {
                    sb.append(stack.peek().index).append(" ");
                    stack.push(new Node(number, i + 1));
                }
            }
        }
        System.out.println(sb);
    }

    static class Node {
        int number;
        int index;

        public Node(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }
}