import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map; // 0 빈칸, 1, 사과, 2 몸통
    private static int[][] dir;
    private static int time;
    private static int n;
    private static ArrayDeque<Node> timeInfo = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dir = new int[n][n];
        map[0][0] = 2;
        dir[0][0] = 0;


        int appleCount = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < appleCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y - 1][x - 1] = 1;
        }

        int moveCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < moveCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            timeInfo.offer(new Node(time, command));
        }

        Snake snake = new Snake();
        while (true) {

            if (snake.isDead()) {
                break;
            }

            boolean changeDir = false;

            if (!timeInfo.isEmpty()) {
                if (time == timeInfo.peek().time) {
                    changeDir = true;
                }
            }
            snake.move(changeDir);


            time++;
        }
        System.out.println(time);
    }

    static class Snake {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int hx, hy, tx, ty;
        boolean dead;
        int headDir;

        public void move(boolean changeDir) {

            if (changeDir) {
                Node info = timeInfo.poll();
                String command = info.command;

                if (command.equals("L")) {
                    headDir--;
                    if (headDir == -1) headDir = 3;
                } else {
                    headDir = (headDir + 1) % 4;
                }
            }

            dir[hy][hx] = headDir;

            int tailDir = dir[ty][tx];

            int ny = hy + dy[headDir];
            int nx = hx + dx[headDir];

            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (map[ny][nx] == 2) {
                    dead = true;
                    return ;
                }

                if (map[ny][nx] == 1) {
                    map[ny][nx] = 2;
                    hy = ny;
                    hx = nx;
                } else {
                    map[ny][nx] = 2;
                    hy = ny;
                    hx = nx;

                    map[ty][tx] = 0;
                    ty = ty + dy[tailDir];
                    tx = tx + dx[tailDir];
                }
            } else {
                dead = true;
                return ;
            }

        }

        public boolean isDead() {
            return dead;
        }


    }

    static class Node {
        int time;
        String command;

        public Node(int time, String command) {
            this.time = time;
            this.command = command;
        }
    }
}