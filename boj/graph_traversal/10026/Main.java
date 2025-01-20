import java.io.*;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char[][] map;
    private static int n;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        initGraph();

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count1++;
                }
            }
        }

        rollBackVisited();
        setGtoR();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count2++;
                }
            }
        }

        System.out.println(count1 + " " + count2);

    }

    private static void rollBackVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        int color = map[y][x];

        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (!visited[ny][nx] && color == map[ny][nx]) {
                    dfs(ny, nx);
                }
            }
        }
    }


    private static void initGraph() throws IOException {
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = input[j];
            }
        }
    }

    private static void setGtoR() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }
    }

}

/**
 * 0 : RED
 * 1 : GREEN
 * 2 : BLUE
 */