class Solution {

    private boolean[][][] installed;
    private int n;

    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        this.installed = new boolean[n + 1][n + 1][2];

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];
            int cmd = frame[3];

            // 삭제
            if (cmd == 0) {
                installed[y][x][type] = false;

                if (!isAvailable()) {
                    installed[y][x][type] = true;
                }

                continue;
            }

            // 설치
            if (canInstall(x, y, type)) {
                installed[y][x][type] = true;
            }
        }

        return makeResult(); // 마지막에 결과 배열로 변환
    }

    private boolean canInstall(int x, int y, int type) {
        if (type == 0) { // 기둥
            return y == 0
                    || hasPillar(x, y - 1)
                    || hasBeam(x - 1, y)
                    || hasBeam(x, y);
        }

        // 보
        return hasPillar(x, y - 1)
                || hasPillar(x + 1, y - 1)
                || (hasBeam(x - 1, y) && hasBeam(x + 1, y));
    }

    private boolean hasPillar(int x, int y) {
        if (x < 0 || x > n || y < 0 || y > n) {
            return false;
        }

        return installed[y][x][0];
    }

    private boolean hasBeam(int x, int y) {
        if (x < 0 || x > n || y < 0 || y > n) {
            return false;
        }

        return installed[y][x][1];
    }

    private boolean isAvailable() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (installed[i][j][0] && !canInstall(j, i, 0))
                    return false;
                if (installed[i][j][1] && !canInstall(j, i, 1))
                    return false;
            }
        }

        return true;
    }

    private int[][] makeResult() {

        int count = 0;

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                for (int type = 0; type <= 1; type++) {
                    if (installed[y][x][type])
                        count++;
                }
            }
        }

        int[][] result = new int[count][3];
        int index = 0;

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                for (int type = 0; type <= 1; type++) {
                    if (installed[y][x][type]) {
                        result[index][0] = x;
                        result[index][1] = y;
                        result[index][2] = type;
                        index++;
                    }
                }
            }
        }

        return result;
    }
}