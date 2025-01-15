import java.io.*;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] dp = new int[12];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
           dp[i] = dp[i - 1] + dp[i -2] + dp[i -3];
        }

        for (int i = 0 ; i < n; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}