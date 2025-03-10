import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, sx, sy, k;
    private static int[][] map;
    private static int[] commands;

    public static void main(String[] args) throws IOException {
        initMap();

        StringBuilder result = new StringBuilder();
        Dice dice = new Dice(sy, sx);

        for (int command : commands) {
            int topValue = dice.move(command);
            if (topValue != -1)
                result.append("" + topValue).append("\n");
        }
        System.out.println(result);
    }

    private static void initMap() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        commands = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }
    }

    static class Dice {
        int[][] dice = new int[4][3];
        int ty, tx, by, bx, y, x;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        public Dice(int y, int x) {
            ty = 3;
            tx = 1;
            by = bx = 1;
            this.y = y;
            this.x = x;
        }

        public int move(int command) {

            int dir = command - 1;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!(0 <= nx && nx < m && 0 <= ny && ny < n)) {
                return -1;
            }

            x = nx;
            y = ny;
            if (command == 3 || command == 4) {
                moveVertical(command);
            } else {
                moveHorizental(command);
            }


            if (map[y][x] == 0) {
                map[y][x] = dice[by][bx];
            } else {
                dice[by][bx] = map[y][x];
                map[y][x] = 0;
            }

            return dice[ty][tx];
        }


        private void moveVertical(int command) {
            if (command == 3) {
                up();
                return;
            }
            down();
        }

        private void moveHorizental(int command) {
            if (command == 1) {
                right();
                return;
            }
            left();
        }

        private void up() {
            int tmp = dice[3][1];
            for (int i = 3; i >= 1; i--) {
                dice[i][1] = dice[i - 1][1];
            }
            dice[0][1] = tmp;
        }

        private void down() {
            int tmp = dice[0][1];
            for (int i = 0; i < 3; i++) {
                dice[i][1] = dice[i + 1][1];
            }
            dice[3][1] = tmp;
        }

        private void right() {
            int tmp = dice[1][0];
            for (int i = 0; i < 2; i++) {
                dice[1][i] = dice[1][i + 1];
            }
            dice[1][2] = dice[3][1];
            dice[3][1] = tmp;
        }

        private void left() {
            int tmp = dice[1][2];

            for (int i = 1; i >= 0; i--) {
                dice[1][i + 1] = dice[1][i];
            }

            dice[1][0] = dice[3][1];
            dice[3][1] = tmp;
        }
    }
}