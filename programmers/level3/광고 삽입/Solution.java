import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        int playTime = toInteger(play_time);
        long[] acc = new long[playTime + 2];
        for (String log : logs) {
            StringTokenizer st = new StringTokenizer(log, "-");

            int startTime = toInteger(st.nextToken());
            int endTime = toInteger(st.nextToken());

            acc[startTime] += 1;
            acc[endTime] -= 1;

        }

        for (int i = 1; i <= playTime; i++) {
            acc[i] += acc[i - 1];
        }

        for (int i = 1; i <= playTime; i++) {
            acc[i] += acc[i - 1];
        }

        int advTime = toInteger(adv_time);
        long maxSum = -1;
        int answerTime = 0;

        for (int start = 0; start + advTime <= playTime; start++) {

            long sum;

            if (start == 0) {
                sum = acc[advTime - 1];
            } else {
                sum = acc[start + advTime - 1] - acc[start - 1];
            }

            if (sum > maxSum) {
                maxSum = sum;
                answerTime = start;
            }
        }

        return toString(answerTime);
    }

    private int toInteger(String playTime) {
        StringTokenizer st = new StringTokenizer(playTime, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());

        return hour * 60 * 60 + minute * 60 + sec;

    }

    private String toString(int time) {
        int hour = time / 3600;
        int minute = time % 3600 / 60;
        int second = time % 60;

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}