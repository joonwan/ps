class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2];

        dp[0][0][0] = dp[0][0][1] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (cityMap[i][j] == 1)
                    continue;

                int fromLeft = 0;
                int fromUp = 0;

                if (i > 0) {
                    fromUp = dp[i - 1][j][1];
                }

                if (j > 0) {
                    fromLeft = dp[i][j - 1][0];
                }

                if (cityMap[i][j] == 0) {
                    int total = (fromUp + fromLeft) % MOD;
                    dp[i][j][0] = total;
                    dp[i][j][1] = total;
                } else if (cityMap[i][j] == 2) {
                    dp[i][j][0] = fromLeft;
                    dp[i][j][1] = fromUp;
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}