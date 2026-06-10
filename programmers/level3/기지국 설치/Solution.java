class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int width = w * 2 + 1;

        for (int station : stations) {
            int left = station - w;
            int right = station + w;

            if (start < left) {
                int gap = left - start;
                answer += (gap + width - 1) / width;
            }

            start = right + 1;
        }

        if (start <= n) {
            answer += (n - start + width) / width;
        }

        return answer;
    }
}