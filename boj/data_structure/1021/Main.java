import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue q = new Queue();

        for (int i = 0 ; i < n; i++) {
            q.offer(i + 1);
        }

        for (int i = 0; i < m; i++) {
            q.calculate(Integer.parseInt(st.nextToken()));
        }

        System.out.println(q.result);
    }

    static class Queue {
        private ArrayDeque<Integer> dq = new ArrayDeque<>();
        private int result;

        public void offer(int number) {
            dq.offer(number);
        }

        public void calculate(int target) {
            
            int peek = dq.peek();

            if (peek == target) {
                dq.poll();
                return;
            }

            int targetIndex = getIndex(target);

            if (targetIndex <= dq.size() / 2) {
                moveLeftFor(targetIndex);
            } else {
                moveRigthFor(dq.size() - targetIndex);
            }
        }

        private void moveRigthFor(int count) {
            for (int i = 0 ; i < count; i++) {
                moveRight();
            }
            dq.poll();
        }

        private void moveRight() {
            int number = dq.pollLast();
            dq.offerFirst(number);
            result++;
        }

        private void moveLeftFor(int count) {
            for (int i = 0 ; i < count; i++) {
                moveLeft();
            }
            dq.poll();
        }

        private void moveLeft() {
            int number = dq.poll();
            dq.offer(number);
            result++;
        }

        private int getIndex(int target) {
            int index = 0;
            Iterator<Integer> iterator = dq.iterator();

            while (iterator.hasNext()) {
                int number = iterator.next();
                if (number == target) {
                    return index;
                }
                index++;
            }

            return index;
        }
    }
}