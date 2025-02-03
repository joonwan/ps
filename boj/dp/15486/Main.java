import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] days;
    private static int[] prices;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        days = new int[n + 1];
        prices = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            days[i + 1] = day;
            prices[i + 1] = price;
        }


        for (int i = 1; i < n + 1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int next = days[i] + i - 1;
            if (next <= n) {
                dp[next] = Math.max(dp[next], dp[i - 1] + prices[i]);
            }
        }
        System.out.println(dp[n]);
    }

}