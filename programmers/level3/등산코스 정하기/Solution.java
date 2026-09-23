import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            int from = path[0];
            int to = path[1];
            int weight = path[2];

            graph[from].add(new Edge(to, weight));
            graph[to].add(new Edge(from, weight));
        }

        boolean[] isSummit = new boolean[n + 1];

        for (int summit : summits) {
            isSummit[summit] = true;
        }

        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>(
                Comparator.comparingInt(state -> state.intensity));

        for (int gate : gates) {
            intensity[gate] = 0;
            pq.offer(new State(gate, 0));
        }

        while (!pq.isEmpty()) {

            State curr = pq.poll();

            int currNode = curr.node;
            int currIntensity = curr.intensity;

            if (currIntensity > intensity[currNode])
                continue;

            if (isSummit[currNode])
                continue;

            for (Edge edge : graph[currNode]) {
                int nextNode = edge.to;
                int edgeWeight = edge.weight;

                int nextIntensity = Math.max(
                        currIntensity,
                        edgeWeight);

                if (nextIntensity < intensity[nextNode]) {
                    intensity[nextNode] = nextIntensity;

                    pq.offer(new State(
                            nextNode,
                            nextIntensity));
                }
            }
        }

        Arrays.sort(summits);
        int answerSummit = 0;
        int answerIntensity = Integer.MAX_VALUE;

        for (int summit : summits) {
            if (intensity[summit] < answerIntensity) {
                answerSummit = summit;
                answerIntensity = intensity[summit];
            }
        }

        return new int[] { answerSummit, answerIntensity };
    }

    static class Edge {

        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State {

        int node, intensity;

        State(int node, int intensity) {
            this.node = node;
            this.intensity = intensity;
        }
    }
}