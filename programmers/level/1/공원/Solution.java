import java.util.Arrays;

class Solution {

    char[][] map;
    int n, m;

    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        initMap(park);
        for (int i = 0 ; i < mats.length; i++) {
            boolean result = run(mats[i]);
            if (result) {
                answer = Math.max(mats[i], answer);
            }
        }


        return answer;
    }

    private boolean run(int mat) {

        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < m; j++) {
                if (map[i][j] == '.') {
                    boolean available = check(mat, i, j);

                    if (available) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(int mat, int y, int x) {

        for (int i = y; i < y + mat ; i++) {
            for (int j = x; j < x + mat; j++) {
                if ( !(i < n && j < m) || map[i][j] != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    private void initMap(String[][] park) {
        n = park.length;
        m = park[0].length;

        map = new char[n][m];
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (park[i][j].equals("-1")) {
                    map[i][j] = '.';
                } else {
                    map[i][j] = park[i][j].charAt(0);
                }
            }
        }
    }
}

