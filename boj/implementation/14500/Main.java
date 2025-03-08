import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int result;
    private static int[] dy = {0, 0, -1, 1};
    private static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        initMap();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, 0);
                checkOther(i, j);
                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }

    private static void checkOther(int y, int x) {
        int tmp = map[y][x];
        for (int i = 0; i < 2; i++) {
            if (!isValidPoint(y + dy[i], x + dx[i])) {
                continue;
            }
            tmp += map[y + dy[i]][x + dx[i]];
            for (int j = i + 1; j < 3; j++) {
                if (!isValidPoint(y + dy[j], x + dx[j])) {
                    continue;
                }
                tmp += map[y + dy[j]][x + dx[j]];
                for (int k = j + 1; k < 4; k++) {
                    if (!isValidPoint(y + dy[k], x + dx[k])) {
                        continue;
                    }
                    tmp += map[y + dy[k]][x + dx[k]];
                    result = Math.max(result, tmp);
                    tmp -= map[y + dy[k]][x + dx[k]];
                }
                tmp -= map[y + dy[j]][x + dx[j]];
            }
            tmp -= map[y + dy[i]][x + dx[i]];
        }
    }

    private static void dfs(int y, int x, int count, int val) {
        int tmp = val + map[y][x];

        if (count == 3) {
            result = Math.max(result, tmp);
            return ;
        }

        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if (isValidPoint(ny, nx) && !visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(ny, nx, count + 1, tmp);
                visited[ny][nx] = false;
            }
        }

    }

    private static boolean isValidPoint(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    private static void initMap() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
    }
}