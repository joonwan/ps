import java.util.*;

class Solution {

    private boolean[] visited;
    private int[] dist;
    private ArrayList<ArrayList<Integer>> graph;

    public int solution(int n, int[][] edge) {
        init(n, edge);
        bfs();
        return getMaxDistCount(dist);
    }

    private int getMaxDistCount(int[] dist) {
        int count = 0;
        int max = 0;

        for (int d : dist) {
            if (d < max)
                continue;
            if (d == max) {
                count++;
                continue;
            }
            max = d;
            count = 1;
        }

        return count;
    }

    private void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        dist[1] = 0;
        visited[1] = true;

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

    private void init(int n, int[][] edge) {
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
    }

}