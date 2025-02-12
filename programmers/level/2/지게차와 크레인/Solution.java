import java.util.Arrays;
import java.util.ArrayDeque;

class Solution {

    char[][] map;
    int n, m;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        initMap(storage);

        for (String request : requests) {
            char c = request.charAt(0);

            if (request.length() == 1) {
                removeOne(c);
                continue;
            }
            removeAll(c);
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != '.') {
                    answer++;
                }
            }
        }
        return answer;
    }

    private void removeOne(char c) {
        ArrayDeque<Node> targets = new ArrayDeque<>();
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == c && (isOutSide(i, j) || isConnectWithWall(i, j))) {
                    targets.add(new Node(i, j));
                }
            }
        }

        for (Node target : targets) {
            map[target.y][target.x] = '.';
        }
    }

    private boolean isConnectWithWall(int y, int x) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new Node(y, x));

        while (!q.isEmpty()) {
            Node now = q.poll();
            visited[now.y][now.x] = true;

            if (isOutSide(now.y, now.x)) {
                return true;
            }

            for (int i = 0 ; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if (!visited[ny][nx] && map[ny][nx] == '.') {
                        q.offer(new Node(ny, nx));
                    }
                }
            }
        }
        return false;
    }

    private boolean isOutSide(int i, int j) {
        return i == 0 || i == n - 1 || j == 0 || j == m - 1;
    }

    private void removeAll(char c) {
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == c) {
                    map[i][j] = '.';
                }
            }
        }
    }

    private void initMap(String[] storage) {
        n = storage.length;
        m = storage[0].length();

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = storage[i].toCharArray();
        }
    }

    static class Node {
        int y;
        int x;

        public Node (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}