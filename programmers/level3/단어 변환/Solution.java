import java.util.*;

class Solution {

    private int[] dists;
    private ArrayList<ArrayList<Integer>> graph;

    public int solution(String begin, String target, String[] words) {

        // 1. filtering
        if (!contains(words, target))
            return 0;

        // 2. make graph
        ArrayList<String> wl = createWordList(begin, words);
        graph = createGraph(wl);

        // 4. init dist array
        dists = new int[wl.size()];
        for (int i = 0; i < wl.size(); i++)
            dists[i] = Integer.MAX_VALUE;
        dists[0] = 0;

        // 5. bfs
        bfs();

        // 6. find target index
        int targetIndex = getTargetIndex(target, wl);

        // 7. return result
        if (dists[targetIndex] == Integer.MAX_VALUE)
            return 0;
        return dists[targetIndex];
    }

    private boolean contains(String[] words, String target) {

        for (String word : words) {
            if (word.equals(target))
                return true;
        }

        return false;
    }

    private void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(0);

        while (!q.isEmpty()) {
            int now = q.poll();

            ArrayList<Integer> nexts = graph.get(now);
            for (int next : nexts) {
                if (dists[next] <= dists[now] + 1)
                    continue;
                dists[next] = dists[now] + 1;
                q.offer(next);
            }
        }
    }

    private ArrayList<String> createWordList(String begin, String[] words) {
        ArrayList<String> wl = new ArrayList<>();

        wl.add(begin);
        for (String word : words) {
            wl.add(word);
        }

        return wl;
    }

    private ArrayList<ArrayList<Integer>> createGraph(ArrayList<String> wl) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < wl.size(); i++) {

            String now = wl.get(i);
            ArrayList<Integer> nexts = new ArrayList<>();

            for (int j = 0; j < wl.size(); j++) {
                if (i == j)
                    continue;

                String other = wl.get(j);
                if (diffCount(now, other) == 1)
                    nexts.add(j);
            }

            graph.add(nexts);
        }

        return graph;
    }

    private int diffCount(String s1, String s2) {
        int dc = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                dc++;
        }

        return dc;
    }

    private int getTargetIndex(String target, ArrayList<String> wl) {
        for (int i = 0; i < wl.size(); i++) {
            if (target.equals(wl.get(i)))
                return i;
        }

        return -1;
    }

}