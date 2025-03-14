import java.io.*;
import java.util.ArrayDeque;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        char[] data = br.readLine().toCharArray();
        ResultQueue rq = new ResultQueue();
        Stack stack = new Stack();
        int level = 0;
        boolean flag = true;

        for (int i = 0; i < data.length; i++) {
            char c = data[i];
            if (c == '(' || c == '[') {
                stack.push(c, level++);
            } else {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                }

                Node pop = stack.pop();
                if (c == ')' && pop.value == 3) {
                    flag = false;
                    break ;
                }

                if (c == ']' && pop.value == 2) {
                    flag = false;
                    break;
                }
                rq.push(pop);
                level--;
            }
        }
        if (!flag || rq.size() != 1) {
            System.out.println(0);
        } else {
            System.out.println(rq.getResult());
        }
    }

    static class ResultQueue {
        ArrayDeque<Node> results = new ArrayDeque<>();

        public String toString() {
            return results.toString();
        }

        public int size() {
            return results.size();
        }

        public int getResult() {
            return results.poll().value;
        }

        public void push(Node now) {
            if (results.isEmpty()) {
                results.push(now);
                return ;
            }

            Node before = results.pop();
            while (before != null && now.level <= before.level) {
                if (now.level == before.level) {
                    now.add(before.value);
                } else {
                    now.multiply(before.value);
                }

                if (!results.isEmpty()) {
                    before = results.pop();
                } else {
                    before = null;
                }
            }

            if (before != null) results.push(before);
            results.push(now);
        }
    }

    static class Stack {
        ArrayDeque<Node> stack = new ArrayDeque<>();

        public void push(int c, int level) {
            if (c == '(') {
                stack.push(new Node(2, level));
            } else {
                stack.push(new Node(3, level));
            }
        }

        public Node pop() {
            return stack.pop();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public String toString() {
            return stack.toString();
        }
    }

    static class Node {
        int level, value;

        public Node (int value, int level) {
            this.level = level;
            this.value = value;
        }

        public void multiply(int other) {
            value *= other;
        }

        public void add(int other) {
            value += other;
        }

        @Override
        public String toString() {
            return "[ level = " + level  + " , value = " + value + " ]";
        }
    }

}