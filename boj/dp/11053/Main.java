import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        dp[1] = 1;

        for (int i = 0; i < n; i++) {
            num[i + 1] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (num[i] > num[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}