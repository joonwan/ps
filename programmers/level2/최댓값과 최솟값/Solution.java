import java.util.*;

class Solution {
    public String solution(String s) {

        int min = 2147483647;
        int max = -2147483648;

        StringTokenizer st = new StringTokenizer(s);

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            if (min > num) {
                min = num;
            }

            if (max < num) {
                max = num;
            }
        }
        return min + " " + max;
    }
}