class Solution {

    private int answer;
    private int[] weak;
    private int[] dist;
    private int[] order;
    private boolean[] isUsed;
    private int[] extendedWeak;

    public int solution(int n, int[] weak, int[] dist) {
        init(n, weak, dist);
        makeOrder();
        return answer == dist.length + 1 ? -1 : answer;
    }

    private void init(int n, int[] weak, int[] dist) {
        this.answer = dist.length + 1;
        this.weak = weak;
        this.dist = dist;
        this.order = new int[dist.length];
        this.isUsed = new boolean[dist.length];
        this.extendedWeak = new int[weak.length * 2];

        for (int i = 0; i < weak.length; i++) {
            extendedWeak[i] = weak[i];
            extendedWeak[i + weak.length] = weak[i] + n;
        }

    }

    private void makeOrder() {
        for (int i = 0; i < dist.length; i++) {
            isUsed[i] = true;
            dfs(i, 0);
            isUsed[i] = false;
        }
    }

    private void dfs(int now, int depth) {
        order[depth] = now;
        if (depth + 1 == dist.length) {
            check();
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                dfs(i, depth + 1);
                isUsed[i] = false;
            }
        }
    }

    private void check() {
        for (int start = 0; start < weak.length; start++) {

            int friendPtr = 0;
            int weakPtr = start;
            int end = start + weak.length;

            while (friendPtr < dist.length) {
                int nowDist = dist[order[friendPtr]];
                int cover = extendedWeak[weakPtr] + nowDist;

                while (weakPtr < end && extendedWeak[weakPtr] <= cover)
                    weakPtr++;

                friendPtr++;
                if (weakPtr == end) {
                    answer = Math.min(answer, friendPtr);
                    break;
                }
            }
        }
    }
}
