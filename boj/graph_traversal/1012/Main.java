import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int tc;
    private static int m, n, k;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1 , 1};
    private static int[] dy = {1, -1, 0 , 0};

    public static void main(String[] args) throws IOException {

        tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            sol();
        }

    }

    private static void sol() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int count = 0;
        initMap();
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int y, int x) {
       visited[y][x] = true;

       for (int i = 0 ; i < 4; i++) {
           int ny = y + dy[i];
           int nx = x + dx[i];

           if (0 <= ny && ny < n && 0 <=nx && nx < m) {
               if (!visited[ny][nx] && map[ny][nx] == 1) {
                   dfs(ny, nx);
               }
           }
       }
    }

    private static void initMap() throws IOException {
        map = new int[n][m];

        for (int l = 0; l < k; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            map[j][i] = 1;
        }
    }
}