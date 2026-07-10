import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;

        int targetA = scores[0][0];
        int targetB = scores[0][1];
        int maxB = 0;

        Arrays.sort(scores, (s1, s2) -> {
            if (s1[0] == s2[0])
                return s1[1] - s2[1];
            return s2[0] - s1[0];
        });

        for (int[] score : scores) {
            int a = score[0];
            int b = score[1];

            if (b < maxB) {
                if (a == targetA && b == targetB)
                    return -1;
                continue;
            }

            if (a + b > targetA + targetB)
                answer++;
            maxB = Math.max(b, maxB);
        }

        return answer;
    }
}