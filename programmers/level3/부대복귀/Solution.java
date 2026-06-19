import java.util.*;

class Solution {

    private ArrayList<ArrayList<Integer>> graph;
    private boolean[] visited;
    private int[] dist;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        init(n, roads);
        bfs(destination);

        int idx = 0;
        for (int source : sources) {
            answer[idx++] = (dist[source] == Integer.MAX_VALUE ? -1 : dist[source]);
        }

        return answer;
    }

    private void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        dist[start] = 0;
        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                if (visited[next])
                    continue;
                dist[next] = dist[now] + 1;
                visited[next] = true;
                q.offer(next);
            }
        }
    }

    private void init(int n, int[][] roads) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
    }
}