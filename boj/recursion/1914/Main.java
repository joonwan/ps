import java.io.*;
import java.math.BigInteger;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        BigInteger num = new BigInteger("2");
        BigInteger result = num.pow(n).subtract(new BigInteger("1"));

        System.out.println(result);

        if (n <= 20) {
            hanoi(n, 1, 3, 2);
        }
    }

    private static void hanoi(int n, int start, int end, int sub) {
        if (n == 1) {
            move(start, end);
            return;
        }

        hanoi(n - 1, start, sub, end);
        move(start, end);
        hanoi(n - 1, sub, end, start);
    }

    private static void move(int start, int end) {
        System.out.println(start + " " + end);
    }
}