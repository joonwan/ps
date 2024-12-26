import java.util.ArrayDeque;
import java.io.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final String EOF = ".";


    public static void main(String[] args) throws IOException {
        while (true) {
            String input = bf.readLine();

            if (input.equals(EOF)) {
                break;
            }

            if (validInput(input)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean validInput(String input) {
        char[] data = input.toCharArray();
        Stack stack = new Stack();

        for (int i = 0; i < data.length; i++) {
            char c = data[i];

            if (c == '(' || c == '[') {
                stack.push(c);
            }

            if (c == ')' || c == ']') {
                boolean result = stack.pop(c);
                if (!result) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    static class Stack {
        ArrayDeque<String> dq = new ArrayDeque<>();

        public void push(char c) {
            dq.push(c + "");
        }

        public boolean pop(char c) {
            if (c == ')' && !dq.isEmpty() && dq.peek().equals("(")) {
                dq.pop();
                return true;
            }

            if (c == ']' && !dq.isEmpty() && dq.peek().equals("[")) {
                dq.pop();
                return true;
            }

            return false;
        }

        public boolean isEmpty() {
            return dq.isEmpty();
        }
    }
}