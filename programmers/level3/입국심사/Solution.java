class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 0;
        long right = getMax(times) * n;

        while (left <= right) {
            long mid = (right + left) / 2;

            if (canProcess(mid, n, times)) {
                answer = mid;
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }

        return answer;
    }

    private boolean canProcess(long mid, int n, int[] times) {
        long count = 0;

        for (int time : times)
            count += (mid / time);

        return n <= count;
    }

    private long getMax(int[] times) {
        int result = 0;

        for (int time : times)
            result = Math.max(result, time);

        return result;
    }
}