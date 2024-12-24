import java.io.*;
import java.util.ArrayDeque;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bf.readLine());
        Stack stack = new Stack();

        for (int i = 0; i < n; i++) {
            long number = Long.parseLong(bf.readLine());
            stack.push(number);
        }

        System.out.println(stack.sum());

    }

    static class Stack {

        private ArrayDeque<Long> dq = new ArrayDeque<>();

        public void push(long number) {
            if (number == 0) {
                dq.pop();
                return;
            }
            dq.push(number);
        }

        public long sum() {
            long sum = 0;

            while (!dq.isEmpty()) {
                sum += dq.pop();
            }

            return sum;
        }
    }
}