import java.io.*;
import java.util.ArrayDeque;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        Stack stack = new Stack();
        int number = 1;
        int[] targets = getTargetArray(n);
        int targetIndex = 0;

        while (targetIndex < n && number <= n) {

            sb.append(stack.push(number++)).append("\n");

            while (targetIndex < n && stack.size() != 0 && targets[targetIndex] == stack.peek()) {
                sb.append(stack.pop()).append("\n");
                targetIndex++;
            }

        }

        if (stack.size() == 0) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }

    private static int[] getTargetArray(int n) throws IOException {
        int[] targets = new int[n];

        for (int i = 0; i < n; i++) {
            targets[i] = Integer.parseInt(bf.readLine());
        }

        return targets;
    }

    static class Stack {
        private ArrayDeque<Integer> dq = new ArrayDeque<>();

        public String push(int number) {
            dq.push(number);
            return "+";
        }

        public String pop() {
            dq.pop();
            return "-";
        }

        public int peek() {
            return dq.peek();
        }

        public int size() {
            return dq.size();
        }
    }
}