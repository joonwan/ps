import java.util.*;

class Solution {

    private int answer;

    private ArrayList<ArrayList<Integer>> graph;

    public int solution(int[] info, int[][] edges) {
        init(info, edges);
        ArrayList<Integer> candidates = new ArrayList<>();
        candidates.add(0);
        dfs(0, 0, candidates, info);
        return answer;

    }

    private void dfs(int sheep, int wolf, ArrayList<Integer> candidates, int[] info) {
        for (int candidate : candidates) {
            int nextSheep = sheep;
            int nextWolf = wolf;

            if (info[candidate] == 0)
                nextSheep++;
            else
                nextWolf++;

            if (nextWolf >= nextSheep)
                continue;

            answer = Math.max(answer, nextSheep);

            ArrayList<Integer> nextCandidates = new ArrayList<>(candidates);
            nextCandidates.remove(Integer.valueOf(candidate));
            for (int next : graph.get(candidate))
                nextCandidates.add(next);
            dfs(nextSheep, nextWolf, nextCandidates, info);
        }
    }

    private void init(int[] info, int[][] edges) {
        answer = 0;

        graph = new ArrayList<>();
        for (int i = 0; i < info.length; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
        }
    }
}