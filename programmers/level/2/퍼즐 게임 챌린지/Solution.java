class Solution {
    public int solution(int[] diffs, int[] times, long limit) {

        int max = getMax(diffs);
        int min = getMin(diffs);

        while (min < max) {
            int mid = (max + min) / 2;

            long totaltime = getTotalTime(diffs, times, mid);
            if (totaltime <= limit) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

        return max;

    }

    private long getTotalTime(int[] diffs, int[] times,int level) {
        long totalTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            if (level >= diffs[i]) {
                totalTime += (long) times[i];
            } else {
                totalTime += getDelayTime(diffs, times, level, i);
            }
        }
        return totalTime;
    }

    private long getDelayTime(int[] diffs, int[] times,int level, int now) {
        int prev = now - 1;
        return (long)(diffs[now] - level) * (long)(times[now] + times[prev]) + (long)times[now];
    }



    private int getMax(int[] diffs) {
        int max = diffs[0];

        for (int i = 1; i < diffs.length; i++) {
            if (max < diffs[i]) {
                max = diffs[i];
            }
        }
        return max;
    }

    private int getMin(int[] diffs) {
        int min = diffs[0];

        for (int i = 1; i < diffs.length; i++) {
            if (min > diffs[i]) {
                min = diffs[i];
            }
        }
        return min;
    }
}