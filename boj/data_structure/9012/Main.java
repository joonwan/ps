import java.io.*;
import java.util.ArrayDeque;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            if (sol()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean sol() throws IOException {
        char[] data = bf.readLine().toCharArray();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < data.length; i++) {
            char c = data[i];
            if (c == '(') {
                stack.push("(");
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}