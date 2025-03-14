import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static int[] coins;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int coin = coins[i];

            for (int j = coin; j < k + 1; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }

        System.out.println(dp[k]);
    }
}