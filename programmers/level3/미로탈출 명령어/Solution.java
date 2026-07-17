class Solution {

    private int[] dx = { 1, 0, 0, -1 };
    private int[] dy = { 0, -1, 1, 0 };
    private char[] command = { 'd', 'l', 'r', 'u' };

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        x--;
        y--;
        r--;
        c--;

        int minDistance = getDistance(x, y, r, c);

        if (minDistance > k || (k - minDistance) % 2 != 0)
            return "impossible";

        StringBuilder sb = new StringBuilder();

        for (int count = 0; count < k; count++) {
            int remain = k - count - 1;

            for (int dir = 0; dir < 4; dir++) {
                int nx = dx[dir] + x;
                int ny = dy[dir] + y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                int distance = getDistance(nx, ny, r, c);

                if (distance <= remain && (remain - distance) % 2 == 0) {
                    sb.append(command[dir]);
                    x = nx;
                    y = ny;
                    break;
                }
            }
        }

        return sb.toString();
    }

    private int getDistance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }
}