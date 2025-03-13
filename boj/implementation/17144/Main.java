import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, t, sy;
    private static int[][] map;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] agrs) throws IOException {
        initMap();

        for (int i = 0 ; i < t; i++) {
            spread();
            rotate();
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && map[i][j] != -1) {
                    result += map[i][j];
                }
            }
        }

        System.out.println(result);
    }

    private static void rotate() {
        up();
        down();
    }

    private static void up() {
        int y = sy;

        for (int i = y - 2; i >= 0; i--) {
            map[i + 1][0] = map[i][0];
        }

        for (int i = 1; i < m; i++) {
            map[0][i - 1] = map[0][i];
        }

        for (int i = 1; i <= y; i++) {
            map[i -1][m - 1] = map[i][m - 1];
        }

        for (int i = m - 2; i >= 1; i--) {
            map[y][i + 1] = map[y][i];
        }

        map[y][1] = 0;
    }

    private static void down() {
        int y = sy + 1;

        for (int i = y + 2; i < n; i++) {
            map[i - 1][0] = map[i][0];
        }

        for (int i = 1; i < m; i++) {
            map[n - 1][i - 1] = map[n - 1][i];
        }

        for (int i = n - 2; i >= y; i--) {
            map[i + 1][m - 1] = map[i][m - 1];
        }

        for (int i = m - 2; i >= 1; i--) {
            map[y][i + 1] = map[y][i];
        }

        map[y][1] =0;
    }

    private static void spread() {

        ArrayDeque<SpreadDust> spreadDusts = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int nowAmount = map[i][j];
                int spreadCount = 0;
                int spreadAmount = (int) Math.floor((double) nowAmount / 5);
                if (nowAmount != -1 && nowAmount != 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];

                        if (0 <= nx && nx < m && 0 <= ny && ny < n && map[ny][nx] != -1) {
                            spreadCount++;
                            spreadDusts.offer(new SpreadDust(ny, nx, spreadAmount));
                        }
                    }
                }

                map[i][j] -= spreadCount * spreadAmount;
            }
        }

        while (!spreadDusts.isEmpty()) {
            SpreadDust now = spreadDusts.poll();
            map[now.y][now.x] += now.amount;
        }
    }

    private static void initMap() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        boolean init = false;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1 && !init) {
                    init = true;
                    sy = i;
                }
            }
        }
    }

    static class SpreadDust {
        int y, x, amount;

        public SpreadDust(int y, int x, int amount) {
            this.y = y;
            this.x= x;
            this.amount = amount;
        }
    }
}