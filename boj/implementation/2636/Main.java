import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int beforeCount;
    private static int count;
    private static int[] dy = {0, 0, -1, 1};
    private static int[] dx = {1, -1, 0, 0};

    public static void main(String[] agrs) throws IOException {
        initMap();

        int time = 0;
        while (count > 0) {
            spreadAir();
            meltCheese();
            time++;

        }
        System.out.println((time - 1) + "\n" + beforeCount);
    }

    private static void meltCheese() {
        int meltCount = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    meltCount += melt(i, j);
                }
            }
        }
        beforeCount = count;
        count = meltCount;
    }

    private static int melt(int y, int x) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        ArrayDeque<Node> melted = new ArrayDeque<>();
        q.offer(new Node(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            boolean melt = false;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (0 <= nx && nx < m + 1 && 0 <= ny && ny < n + 1) {
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        q.offer(new Node (ny, nx));
                    }

                    if (map[ny][nx] == 0 && visited[ny][nx]) {
                        melt = true;
                    }
                }
            }

            if (melt) {
                melted.offer(now);
            }
        }

        int meltCount = 0;
        while (!melted.isEmpty()) {
            Node now = melted.poll();
            map[now.y][now.x] = 0;
            meltCount ++;
        }
        return meltCount;
    }

    private static void spreadAir() {
        visited = new boolean[n + 1][m + 1];
        bfs(0, 0);
    }

    private static void bfs(int y, int x) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (0 <= nx && nx < m +1 && 0 <= ny && ny < n + 1 && map[ny][nx] == 0) {
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

        map = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) count++;
            }
        }

    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}