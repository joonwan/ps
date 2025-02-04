import java.io.*;

import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];

        if (n <= 3) {
            System.out.println(n);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            dp[i] = i;
        }

        for (int i = 4; i < n + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 1;  j < i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }

        System.out.println(dp[n]);
    }
}