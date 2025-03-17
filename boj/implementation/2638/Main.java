import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, time, count;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        initMap();
        while (count > 0) {
            split();
            melt();
            time++;
        }

        System.out.println(time);
    }

    private static void split() {
        bfs();
    }

    private static void melt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    detect(i, j);
                }
            }
        }
    }

    private static void detect(int y, int x) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        ArrayDeque<Node> melted = new ArrayDeque<>();
        q.offer(new Node(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int airCount = 0;
            for (int i = 0 ; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if (map[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.offer(new Node(ny, nx));
                    }

                    if (map[ny][nx] == 0 && visited[ny][nx]) {
                        airCount++;
                    }
                }
            }

            if (airCount >= 2) {
                melted.offer(now);
            }
        }
        for (Node now : melted) {
            map[now.y][now.x] = 0;
            count--;
        }
    }

    private static void bfs() {
        visited = new boolean[n][m];
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;

                if (0 <= nx && nx < m && 0 <= ny && ny < n && map[ny][nx] == 0) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.offer(new Node(ny, nx));
                    }
                }
            }
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
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
    }

    static class Node {
        int y, x ;
        public Node (int y, int x) {
            this.y = y;
            this.x = x;
        }

        public String toString() {
            return "[ y = " + y + ", " + x + " ]";
        }
    }
}