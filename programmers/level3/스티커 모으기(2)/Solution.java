
class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if (sticker.length == 1)
            return sticker[0];
        if (sticker.length == 2)
            return Math.max(sticker[0], sticker[1]);

        return Math.max(getMax(0, n - 2, sticker), getMax(1, n - 1, sticker));
    }

    private int getMax(int s, int e, int[] sticker) {
        int len = e - s + 1;
        int[] dp = new int[len];

        dp[0] = sticker[s];
        dp[1] = Math.max(dp[0], sticker[s + 1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i + s]);
        }

        return dp[dp.length - 1];

    }
}