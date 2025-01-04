import java.io.*;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        char[] input = br.readLine().toCharArray();
        ArrayDeque<Node> dq = new ArrayDeque<>();

        int index = 0;
        int result = 0;

        while (index < input.length) {
            if (index == input.length - 1) {
                result += dq.poll().count + 1;
                break ;
            }

            char c1 = input[index];
            char c2 = input[index + 1];

            if (c1 == '(' && c2 == ')') {

                Iterator<Node> iterator = dq.iterator();
                while (iterator.hasNext()) {
                    Node node = iterator.next();
                    node.addCount();
                }
                index += 2;
                continue;
            }

            if (c1 == '(') {
                dq.offer(new Node());
            } else {
                Node node = dq.poll();
                result += node.count + 1;
            }
            index++;
        }

        System.out.println(result);
    }

    static class Node {
        int count;

        public void addCount() {
            count++;
        }
    }
}