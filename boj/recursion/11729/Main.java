import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        int count = (int) Math.pow(2, n) - 1;
        bw.write(count + "\n");

        hanoi(n, 1, 3, 2);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void hanoi(int n, int start, int end, int sub) throws IOException {
        if (n == 1) {
            move(start, end);
            return;
        }

        hanoi(n - 1, start, sub, end);
        move(start, end);
        hanoi(n - 1, sub, end, start);
    }

    private static void move(int start, int end) throws IOException {
        bw.write(start + " " + end + "\n");
    }
}