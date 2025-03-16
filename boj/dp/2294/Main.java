import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static int[] dp;
    private static int[] numbers;
    private static int INF = 10_001;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[k + 1];
        numbers = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for (int num : numbers) {
            for (int i = num; i < k + 1; i++) {
                dp[i] = Math.min(dp[i - num] + 1, dp[i]);
            }
        }



        if (dp[k] >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}