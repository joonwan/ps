import java.util.*;

class Solution {

    private ArrayList<ArrayList<Edge>> graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        init(n, fares);
        int[] fromS = dijkstra(n, s);
        int[] fromA = dijkstra(n, a);
        int[] fromB = dijkstra(n, b);

        for (int k = 1; k <= n; k++) {
            answer = Math.min(answer, fromS[k] + fromA[k] + fromB[k]);
        }

        return answer;
    }

    private int[] dijkstra(int n, int start) {
        int[] dist = new int[n + 1];
        dist[start] = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> heap = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        heap.offer(new Node(start, 0));

        while (!heap.isEmpty()) {
            Node now = heap.poll();

            if (now.cost >= dist[now.idx])
                continue;
            dist[now.idx] = now.cost;

            for (Edge edge : graph.get(now.idx)) {
                int nextCost = now.cost + edge.cost;

                if (nextCost >= dist[edge.to])
                    continue;
                heap.offer(new Node(edge.to, nextCost));
            }
        }

        return dist;
    }

    private void init(int n, int[][] fares) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost));
        }
    }

    static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}