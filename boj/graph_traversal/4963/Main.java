import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static boolean[][] visited;
    private static int height;
    private static int width;
    private static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        boolean operate = true;

        while (operate) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            if (height == 0 && width == 0) {
                break;
            }

            map = new int[height][width];
            visited = new boolean[height][width];

            initMap();

            int count = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    private static void dfs(int nowY, int nowX) {
        visited[nowY][nowX] = true;

        for (int i = 0; i < 8; i++) {
            int nextY = nowY + dy[i];
            int nextX = nowX + dx[i];
            if (0 <= nextY && nextY < height && 0 <= nextX && nextX < width) {
                if (!visited[nextY][nextX] && map[nextY][nextX] == 1) {
                    dfs(nextY, nextX);
                }
            }
        }

    }

    private static void initMap() throws IOException {

        for (int i = 0; i < height; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }
    }
}