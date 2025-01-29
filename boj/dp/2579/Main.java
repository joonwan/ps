import java.io.*;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            nums[i + 1] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(nums[1]);
            return;
        }

        if (n == 2) {
            System.out.println(nums[1] + nums[2]);
            return;
        }

        dp[1] = nums[1];
        dp[2] = nums[1] + nums[2];

        for (int i = 3; i < n + 1; i++) {
           dp[i] = Math.max(dp[i - 2], dp[i - 3] + nums[i - 1]) + nums[i];
        }

        System.out.println(dp[n]);
    }
}