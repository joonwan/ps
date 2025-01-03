import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int tc;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            sb.append(sol()).append("\n");
        }

        System.out.println(sb);
    }

    private static String sol() throws IOException {

        Q q = new Q();
        char[] commands = br.readLine().toCharArray();
        int size = Integer.parseInt(br.readLine());
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input.substring(1, input.length() - 1), ",");

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(st.nextToken());
            q.offer(num);
        }

        q.handleCommand(commands);

        return q.getResult();

    }

    static class Q {
        private ArrayDeque<Integer> dq = new ArrayDeque<>();
        private int size;
        private boolean isReversed;
        private boolean error;

        public void handleCommand(char[] commands) {
            for (int i = 0; i < commands.length; i++) {
                char command = commands[i];

                if (command == 'R') {
                    reverse();
                }

                if (command == 'D') {
                    poll();
                }
            }
        }

        public void offer(int num) {
            dq.offer(num);
            size++;
        }

        public void reverse() {
            isReversed = !isReversed;
        }

        public void poll() {
            if (size == 0) {
                error = true;
                return;
            }

            if (isReversed) {
                dq.pollLast();
            } else {
                dq.poll();
            }
            size--;
        }

        public String getResult() {
            if (error) {
                return "error";
            }

            ArrayList<String> res = new ArrayList<>();

            while (!dq.isEmpty()) {
                if (isReversed) {
                    res.add(dq.pollLast() + "");
                } else {
                    res.add(dq.poll() + "");
                }
            }

            return "[" + String.join(",", res) + "]";
        }

    }
}