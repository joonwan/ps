import java.util.StringTokenizer;

class Solution {

    int n, m, y, x;
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    char[][] map;

    public int[] solution(String[] park, String[] routes) {

        initMap(park);

        for (int i = 0; i < routes.length; i++) {
            StringTokenizer st = new StringTokenizer(routes[i]);

            String direction = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());

            if (isValidCommand(direction, dist)) {
                move(direction, dist);
            }
        }

        int[] answer = new int[2];
        answer[0] = y;
        answer[1] = x;
        return answer;
    }

    private void move(String direction, int dist) {
        int dirIdx = getDirIdx(direction);

        for (int i = 0; i < dist; i++) {
            y += dy[dirIdx];
            x += dx[dirIdx];
        }
    }

    private boolean isValidCommand(String direction,int dist) {
        int dirIdx = getDirIdx(direction);
        int ny = y;
        int nx = x;
        for (int i = 0 ; i < dist; i++) {
            ny += dy[dirIdx];
            nx += dx[dirIdx];

            if (!(0 <= ny && ny < n && 0 <= nx && nx < m)) {
                return false;
            } else {
                if (map[ny][nx] == 'X') {
                    return false;
                }
            }
        }
        return true;
    }

    private int getDirIdx(String direction) {
        if (direction.equals("E")) return 0;
        if (direction.equals("W")) return 1;
        if (direction.equals("S")) return 2;
        return 3;
    }


    private void initMap(String[] park) {
        n = park.length;
        m = park[0].length();

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = park[i].toCharArray();

            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') {
                    y = i;
                    x = j;
                }
            }
        }
    }

}