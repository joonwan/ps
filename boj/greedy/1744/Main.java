import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> positivePq = new PriorityQueue<>((n1, n2) -> n2.intValue() - n1.intValue());
        PriorityQueue<Long> negativePq = new PriorityQueue<>();

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(bf.readLine());
            if (num > 0) {
                positivePq.offer(num);
            } else {
                negativePq.offer(num);
            }
        }

        System.out.println(getMaxSum(positivePq) + getMaxSum(negativePq));

    }

    private static long getMaxSum(PriorityQueue<Long> pq) {
       long result = 0;

        while (pq.size() >= 2) {
            long num1 = pq.poll();
            long num2 = pq.poll();

            long sum = num1 + num2;
            long mul = num1 * num2;

            result += Math.max(sum, mul);
        }

        if (!pq.isEmpty()) {
            result += pq.poll();
        }

        return result;
    }
}