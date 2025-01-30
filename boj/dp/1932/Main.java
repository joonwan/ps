import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int nums[][];
    private static int dp[][];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        nums = new int[n][n];
        dp = new int[n][n];

        for (int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = nums[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = nums[i][j] + dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] = nums[i][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i -1][j - 1] , dp[i - 1][j]) + nums[i][j];
                }
            }
        }

        int max = 0;

        for (int i = 0 ; i < n; i++) {
            max = Math.max(dp[n - 1][i], max);
        }

        System.out.println(max);
    }
}