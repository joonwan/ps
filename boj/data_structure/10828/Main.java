import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int number = Integer.parseInt(st.nextToken());
                stack.push(number);
            } else {
                sb.append(stack.handleCommand(command)).append("\n");
            }
        }

        System.out.println(sb);
    }


    static class Stack {

        int size;
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        public void push(int number) {
            dq.push(number);
            size++;
        }

        public int handleCommand(String command) {
            if (command.equals("pop")) {
                return pop();
            } else if (command.equals("size")) {
                return size();
            } else if (command.equals("empty")) {
                return empty();
            } else {
                return top();
            }
        }

        private int pop() {
            if (size == 0) {
                return -1;
            }
            size -= 1;
            return dq.pop();
        }

        private int size() {
            return size;
        }

        private int empty() {
            if (size == 0) {
                return 1;
            }
            return 0;
        }

        private int top() {
            if (size == 0) {
                return -1;
            }
            return dq.peek();
        }
    }
}