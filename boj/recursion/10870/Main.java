import java.io.*;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        if (n == 0) {
            System.out.println(0);
            return;
        }
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        System.out.println(arr[n]);
    }
}