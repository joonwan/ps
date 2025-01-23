import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int MAX_HEIGHT = 0;
    private static int MIN_HEIGHT = 2147483647;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                MAX_HEIGHT = Math.max(MAX_HEIGHT, graph[i][j]);
                MIN_HEIGHT = Math.min(MIN_HEIGHT, graph[i][j]);
            }
        }

        int max = 1;

        for (int i = MIN_HEIGHT; i <= MAX_HEIGHT; i++) {
            initVisited(visited);
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && i < graph[j][k]) {
                        dfs(i, j, k);
                        count++;
                    }
                }
            }
            max = Math.max(count, max);

        }

        System.out.println(max);
    }

    private static void dfs(int height, int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[ny][nx] && graph[ny][nx] > height) {
                dfs(height, ny, nx);
            }
        }
    }

    private static void initVisited(boolean[][] visited) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }
}