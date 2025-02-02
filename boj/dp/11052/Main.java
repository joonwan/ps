import java.io.*;
import java.util.StringTokenizer;
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i + 1] = Integer.parseInt(st.nextToken());
        }

        dp[1] = nums[1];

        sol(n);

        System.out.println(dp[n]);
    }


    private static void sol(int n) {

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                int tmp =  dp[i - j] + dp[j];
                dp[i] = Math.max(dp[i], (dp[i - j] + dp[j]));
                dp[i] = Math.max(dp[i], nums[i]);
            }
        }
    }

}