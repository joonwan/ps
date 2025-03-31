import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] result;
    private static ArrayDeque<Node> stack = new ArrayDeque<>();

    public static void main(String[] agrs) throws IOException {
        n = Integer.parseInt(br.readLine());
        result = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            Node node = new Node(num, i + 1);

            while (!stack.isEmpty() && stack.peek().val < num) {
                Node pop = stack.pop();
                result[pop.idx - 1] = pop.parent;
            }

            if (!stack.isEmpty()) {
                node.parent = stack.peek().idx;
            }

            stack.push(node);
        }

        while (!stack.isEmpty()) {
            Node now = stack.pop();
            result[now.idx - 1] = now.parent;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }

    static class Node {
        int val;
        int idx;
        int parent;

        public Node (int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
}