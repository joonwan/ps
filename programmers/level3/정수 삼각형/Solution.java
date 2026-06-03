class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;
        int width = triangle[height - 1].length;

        int[][] sum = new int[height][width];
        sum[0][0] = triangle[0][0];

        for (int i = 0; i < height - 1; i++) {
            for (int j = 0; j <= i; j++) {
                sum[i + 1][j] = Math.max(sum[i + 1][j], sum[i][j] + triangle[i + 1][j]);
                sum[i + 1][j + 1] = Math.max(sum[i + 1][j + 1], sum[i][j] + triangle[i + 1][j + 1]);
            }
        }

        for (int i = 0; i < width; i++) {
            answer = Math.max(answer, sum[height - 1][i]);
        }

        return answer;
    }
}