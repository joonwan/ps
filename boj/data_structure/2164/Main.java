import java.io.*;
import java.util.ArrayDeque;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bf.readLine());;

        Stack stack = new Stack(n);
        stack.operate();

        System.out.println(stack.getLastNumber());
    }

    static class Stack {

        private ArrayDeque<Integer> dq = new ArrayDeque<>();

        public Stack(int size) {
            for (int i = size; i > 0; i--) {
                dq.push(i);
            }
        }

        public void operate() {
            while (dq.size() > 1) {
                dq.pop();
                dq.offer(dq.pop());
            }
        }

        public int getLastNumber() {
            return dq.peek();
        }
    }
}