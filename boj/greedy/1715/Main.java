import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int result = 0;

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            q.offer(Integer.parseInt(bf.readLine()));
        }

        while (q.size() > 1) {
            int num1 = q.poll();
            int num2 = q.poll();
            result += num1 + num2;
            q.offer(num1 + num2);
        }


        System.out.println(result);
    }


}