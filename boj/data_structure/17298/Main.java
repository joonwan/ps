import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        ArrayDeque<Node> stack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                stack.push(new Node(number, i));
            } else {
                while (!stack.isEmpty() && stack.peek().number < number) {
                    Node node = stack.pop();
                    nums[node.index] = number;
                }

                stack.push(new Node(number, i));
            }
        }

        while (!stack.isEmpty()) {
            nums[stack.pop().index] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i =0; i < n; i++) {
            sb.append(nums[i]).append(" ");
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