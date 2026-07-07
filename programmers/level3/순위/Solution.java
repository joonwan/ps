import java.util.*;

class Solution {

    private ArrayList<ArrayList<Integer>> graph;
    private int[] in;
    private int[] out;

    public int solution(int n, int[][] results) {
        int answer = 0;

        init(n, results);
        for (int i = 1; i <= n; i++)
            bfs(i, n);

        for (int i = 1; i <= n; i++) {
            if (in[i] + out[i] == n - 1)
                answer++;
        }
        return answer;
    }

    private void bfs(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                if (visited[next])
                    continue;
                visited[next] = true;
                out[start]++;
                in[next]++;
                q.offer(next);
            }
        }
    }

    private void init(int n, int[][] results) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int[] r : results) {
            int win = r[0];
            int lose = r[1];

            graph.get(lose).add(win);
        }

        in = new int[n + 1];
        out = new int[n + 1];
    }
}