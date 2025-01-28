import java.io.*;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int MOD = 10_007;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= MOD;
                }
            }
        }

        System.out.println(dp[n][0] % MOD);
    }
}