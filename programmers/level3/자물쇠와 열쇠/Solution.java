import java.util.*;

class Solution {

    ArrayList<Integer> keyPoints;
    int n, m, emptyCount;

    public boolean solution(int[][] key, int[][] lock) {

        init(key, lock);
        for (int i = 0; i < 4; i++) {
            // 1. 90 도 회전
            rotate();

            // 2. matching 되면 return true
            if (isMatchable(lock))
                return true;
        }

        // 3. 모든 경우가 안됨 return false
        return false;
    }

    // 초기화
    private void init(int[][] key, int[][] lock) {
        n = lock.length;
        m = key.length;
        emptyCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lock[i][j] == 0)
                    emptyCount++;
            }
        }

        keyPoints = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (key[i][j] == 1)
                    keyPoints.add(i * m + j);
            }
        }
    }

    // 90 도 회전
    private void rotate() {

        ArrayList<Integer> newPoints = new ArrayList<>();

        for (int point : keyPoints) {
            int y = point / m;
            int x = point % m;

            int tmp = y;
            y = x;
            x = m - 1 - tmp;

            newPoints.add(y * m + x);
        }

        keyPoints = newPoints;
    }

    private boolean isMatchable(int[][] lock) {

        for (int i = -n; i < n; i++) {
            for (int j = -n; j < n; j++) {
                int tmp = 0;
                boolean flag = true;
                for (int point : keyPoints) {
                    int y = point / m + i;
                    int x = point % m + j;

                    if (0 > y || 0 > x || n <= y || n <= x)
                        continue;
                    if (lock[y][x] == 0)
                        tmp++;
                    if (lock[y][x] == 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag && tmp == emptyCount)
                    return true;
            }
        }
        return false;
    }

}