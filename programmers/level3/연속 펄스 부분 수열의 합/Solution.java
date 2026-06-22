
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        long dp1 = 0;
        long dp2 = 0;

        for (int i = 0; i < sequence.length; i++) {
            int v1 = (i % 2 == 0) ? sequence[i] : -1 * sequence[i];
            int v2 = (i % 2 == 0) ? -1 * sequence[i] : sequence[i];

            dp1 = Math.max(v1, dp1 + v1);
            dp2 = Math.max(v2, dp2 + v2);

            answer = Math.max(answer, Math.max(dp1, dp2));
        }

        return answer;
    }
}