class Solution {

    int[] dx = { 0, -1 };
    int[] dy = { -1, 0 };

    public int solution(int m, int n, int[][] puddles) {
        boolean[][] isPuddle = new boolean[n][m];
        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for (int[] puddle : puddles) {
            isPuddle[puddle[1] - 1][puddle[0] - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isPuddle[i][j])
                    continue;

                for (int k = 0; k < 2; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                        continue;
                    dp[i][j] = (dp[i][j] + dp[ny][nx]) % 1_000_000_007;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}