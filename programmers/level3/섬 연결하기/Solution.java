import java.util.*;

class Solution {

    int[] parents;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parents = new int[n];
        for (int i = 0; i < n; i++)
            parents[i] = i;
        Arrays.sort(costs, (a1, a2) -> a1[2] - a2[2]);

        int connected = 0;
        int idx = 0;

        while (connected < n - 1) {
            int[] edge = costs[idx++];
            int n1 = edge[0];
            int n2 = edge[1];
            int cost = edge[2];

            if (find(n1) == find(n2))
                continue;
            union(n1, n2);
            answer += cost;
            connected++;
        }

        return answer;
    }

    private void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 < p2) {
            parents[p2] = p1;
            return;
        }

        parents[p1] = p2;
    }

    private int find(int n) {
        if (n == parents[n])
            return n;

        return parents[n] = find(parents[n]);
    }
}