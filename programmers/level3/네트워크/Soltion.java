import java.util.*;

class Solution {

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        init(n, computers);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }

        return answer;
    }

    private void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            ArrayList<Integer> nexts = graph.get(now);

            for (int next : nexts) {
                if (visited[next])
                    continue;

                visited[next] = true;
                q.offer(next);
            }
        }
    }

    private void init(int n, int[][] computers) {

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || computers[i][j] != 1)
                    continue;

                graph.get(i + 1).add(j + 1);

            }
        }
    }
}