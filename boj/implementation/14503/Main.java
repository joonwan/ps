import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        initMap();
        Robot robot = new Robot(y, x, dir);
        robot.run();

        System.out.println(robot.count);
    }

    private static void initMap() throws IOException {
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Robot {
        int count;
        boolean operate;
        // 북 서 남 동
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        int x, y, dir;

        public Robot(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            if (dir == 1) {
                this.dir = 3;
            } else if (dir == 3) {
                this.dir = 1;
            } else {
                this.dir =dir;
            }
            this.operate = true;
        }

        public void run() {
            while (operate) {
                // 0 -> 청소 안됨 1 -> 벽 2 -> 청소됨
                if (map[y][x] == 0) {
                    cleaning();
                }

                boolean canClean = isCanCleaning();
                if (canClean) {
                    while (true) {
                        dir = (dir + 1) % 4;
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                            if (map[ny][nx] == 0) {
                                x = nx;
                                y = ny;
                                break;
                            }
                        }
                    }
                } else {
                    int nx = x - dx[dir];
                    int ny = y - dy[dir];

                    if (0 <= nx && nx < m && 0 <= ny && ny < n && map[ny][nx] != 1){
                        y = ny;
                        x = nx;
                    } else{
                        operate = false;
                    }
                }
            }
        }

        private void cleaning() {
            map[y][x] = 2;
            count++;
        }

        private boolean isCanCleaning() {
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                    if (map[ny][nx] == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}