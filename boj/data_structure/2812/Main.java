import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int deleteCount = 0;

        for (int i = 0; i < n; i++) {
            int number = input[i] - '0';

            if (stack.isEmpty()) {
                stack.push(number);
            } else {
                while (!stack.isEmpty() && stack.peek() < number && deleteCount < k) {
                    stack.pop();
                    deleteCount++;
                }
                stack.push(number);
            }
        }

        ArrayDeque<Integer> res = new ArrayDeque<>();

        while (!stack.isEmpty()) {
            res.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();

        while (!res.isEmpty()) {
            sb.append(res.pop());
        }

        String result = sb.toString();
        System.out.println(result.substring(0, result.length() - (k - deleteCount)));

    }
}