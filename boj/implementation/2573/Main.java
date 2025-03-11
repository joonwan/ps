import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayDeque<Node> visits;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        initMap();
        int year = simulate();
        System.out.println(year);
    }

    private static int simulate() {
        int year = 0;
        int count = 0;
        while (true) {
            visits = new ArrayDeque<>();
            count = getCount();
            if (count != 1) break;


            while (!visits.isEmpty()) {
                Node now = visits.poll();
                map[now.y][now.x] = map[now.y][now.x] - now.count;
                if (map[now.y][now.x] <= 0) map[now.y][now.x] = 0;
            }
            year++;
//            for (int i = 0; i < n; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println("=======");
        }
        if (count == 0) {
            return 0;
        }
        return year;
    }

    private static int getCount() {
        int count = 0;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int y, int x) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        visited[y][x] = true;
        q.offer(new Node(y, x));

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (0 <= nx && nx < m && 0 <= ny && ny < n && !visited[ny][nx]) {
                    if (map[ny][nx] != 0) {
                        visited[ny][nx] = true;
                        q.offer(new Node(ny, nx));
                    } else if (map[ny][nx] == 0) {
                        now.addCount();
                    }
                }
            }
            visits.offer(now);
        }

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
    }

    static class Node {
        int y, x, count;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
            this.count = 0;
        }

        public void addCount() {
            count++;
        }
    }
}