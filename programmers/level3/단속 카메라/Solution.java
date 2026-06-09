import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (a1, a2) -> {
            if (a1[0] == a2[0])
                return a1[1] - a2[1];
            return a1[0] - a2[0];
        });

        int target = routes[0][1];

        for (int i = 1; i < routes.length; i++) {

            int[] now = routes[i];
            if (target >= now[0]) {
                target = Math.min(target, now[1]);
                continue;
            }
            target = now[1];
            answer++;
        }

        return answer;
    }
}
