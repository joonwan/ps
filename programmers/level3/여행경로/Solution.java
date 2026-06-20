import java.util.*;

class Solution {

    boolean[] used;
    String[] answer;

    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];

        Arrays.sort(tickets, (a1, a2) -> {
            if (a1[0].equals(a2[0])) {
                return a1[1].compareTo(a2[1]);
            }
            return a1[0].compareTo(a2[0]);
        });

        ArrayList<String> route = new ArrayList<>();
        route.add("ICN");

        dfs("ICN", tickets, route, 0);

        return answer;
    }

    private boolean dfs(String now, String[][] tickets, ArrayList<String> route, int count) {

        if (count == tickets.length) {
            answer = route.toArray(new String[0]);
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (used[i])
                continue;
            if (!tickets[i][0].equals(now))
                continue;

            used[i] = true;
            route.add(tickets[i][1]);

            if (dfs(tickets[i][1], tickets, route, count + 1)) {
                return true;
            }

            used[i] = false;
            route.remove(route.size() - 1);
        }

        return false;
    }
}