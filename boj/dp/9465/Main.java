import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            sol();
        }
    }

    private static void sol() throws IOException {
        int n  = Integer.parseInt(br.readLine());
        int[][] nums = new int[2][n + 1];
        int[][] dp = new int[2][n + 1];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums[i][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1] = nums[0][1];
        dp[1][1] = nums[1][1];

        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(Math.max(dp[0][i - 2], dp[1][i - 2]), dp[1][i - 1]) + nums[0][i];
            dp[1][i] =  Math.max(Math.max(dp[0][i - 2], dp[1][i - 2]), dp[0][i - 1]) + nums[1][i];
        }

        System.out.println(Math.max(dp[0][n], dp[1][n]));
    }
}