import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        Deque dq = new Deque();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            String command = st.nextToken();

            if (command.equals("push_back")) {
                int number = Integer.parseInt(st.nextToken());
                dq.pushBack(number);
            } else if (command.equals("push_front")) {
                int number = Integer.parseInt(st.nextToken());
                dq.pushFront(number);
            } else {
                sb.append(dq.getData(command)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class Deque {
        private final ArrayDeque<Integer> dq = new ArrayDeque<>();
        private int size;

        public void pushFront(int n) {
            dq.push(n);
            size++;
        }

        public void pushBack(int n) {
            dq.offer(n);
            size++;
        }

        public int getData(String command) {
            if (command.equals("pop_front")) {
                return popFront();
            }

            if (command.equals("pop_back")) {
                return popBack();
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

        private int popFront() {
            if (size == 0) {
                return -1;
            }

            size--;
            return dq.poll();
        }

        private int popBack() {
            if (size == 0) {
                return -1;
            }

            size--;
            return dq.pollLast();
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