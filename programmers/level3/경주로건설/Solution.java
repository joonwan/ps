import java.util.*;

class Solution {

    private int[][][] cost;
    private int[] dx = { 0, 0, -1, 1 };
    private int[] dy = { 1, -1, 0, 0 };
    private int answer, n, m;

    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        n = board.length;
        m = board[0].length;

        cost = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
        }

        // 0: 가로
        // 1: 세로

        dfs(0, 0, 1, 0, board);
        dfs(0, 0, 0, 0, board);
        return answer;
    }

    private void dfs(int y, int x, int dir, int curCost, int[][] board) {

        if (y == n - 1 && x == m - 1) {
            answer = Math.min(answer, curCost);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 > ny || 0 > nx || n <= ny || m <= nx)
                continue;
            if (board[ny][nx] == 1)
                continue;

            int nextDir = isVertiIdx(i) ? 1 : 0;
            int nextCost = curCost + 100;

            if (dir != nextDir)
                nextCost += 500;
            if (nextCost > cost[ny][nx][nextDir])
                continue;

            cost[ny][nx][nextDir] = nextCost;
            dfs(ny, nx, nextDir, nextCost, board);
        }
    }

    private boolean isVertiIdx(int idx) {
        return idx == 0 || idx == 1;
    }

}