import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int k;
    private static int[][] dp;
    private final static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[k + 1][n + 1];

        for (int i = 1; i < k + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j] % MOD + dp[i][j - 1] % MOD) % MOD;
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}