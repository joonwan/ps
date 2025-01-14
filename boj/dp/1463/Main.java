import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private final static int MAX_VAL = 1_000_000;
    private static int[] dp = new int[MAX_VAL + 1];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i < n + 1; i++) {
            int res = 2147483647;

            if (i % 3 == 0) {
                res = Math.min(res, dp[i / 3] + 1);
            }

            if (i % 2 == 0) {
                res = Math.min(res, dp[i / 2] + 1);
            }

            res = Math.min(res, dp[i - 1] + 1);

            dp[i] = res;
        }

        System.out.println(dp[n]);
    }
}