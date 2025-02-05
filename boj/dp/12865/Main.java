import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static int[][] dp;
    private static int[] weights;
    private static int[] values;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][k + 1];
        weights = new int[n + 1];
        values = new int[n + 1];



        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            weights[i + 1] = Integer.parseInt(st.nextToken());
            values[i + 1] = Integer.parseInt(st.nextToken());

        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int diff = j - weights[i];
                if (diff < 0) {
                   dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][diff] + values[i]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}