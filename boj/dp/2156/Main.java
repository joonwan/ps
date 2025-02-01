import java.io.*;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] nums;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(nums[1]);
            return;
        }

        dp[1] = nums[1];
        dp[2] = nums[1] + nums[2];

        for (int i = 3; i <= n; i++) {
            int tmp = Math.max(dp[i - 2], dp[i - 3] + nums[i - 1]) + nums[i];
            dp[i] = Math.max(tmp, dp[i - 1]);
        }


        System.out.println(dp[n]);
    }
}