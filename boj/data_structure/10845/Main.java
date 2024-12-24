import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        Queue q = new Queue();

        for (int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            String command = st.nextToken();
            if (command.equals("push")) {
                int number = Integer.parseInt(st.nextToken());
                q.push(number);
            } else {
                sb.append(q.handleCommand(command)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class Queue {
        int size;
        private ArrayDeque<Integer> dq = new ArrayDeque<>();

        public void push(int number) {
            dq.offer(number);
            size++;
        }

        public int handleCommand(String command) {
            if (command.equals("pop")) {
                return pop();
            }

            if (command.equals("size")) {
                return size();
            }

            if (command.equals("empty")) {
                return empty();
            }

            if (command.equals("front")) {
                return front();
            }

            return back();

        }

        private int pop() {
            if (size == 0) {
                return -1;
            }
            size--;
            return dq.poll();
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

        private int front() {
            if (size == 0) {
                return -1;
            }
            return dq.peekFirst();
        }

        private int back() {
            if (size == 0) {
                return -1;
            }
            return dq.peekLast();
        }
    }
}