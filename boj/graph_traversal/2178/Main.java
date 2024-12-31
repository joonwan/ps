import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] map;
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        initMap();

        bfs();

        System.out.println(visited[n -1][m - 1]);
    }

    private static void bfs() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0));
        visited[0][0] = 1;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0 ; i < 4; i++) {
                int next_y = now.y + dy[i];
                int next_x = now.x + dx[i];

                if (0 <= next_y && next_y < n  && 0 <= next_x && next_x < m) {
                    if (visited[next_y][next_x] == 0 && map[next_y][next_x] == 1) {
                        visited[next_y][next_x] = visited[now.y][now.x] + 1;
                        q.offer(new Node(next_y, next_x));
                    }
                }
            }
        }
    }

    private static void initMap() throws IOException {
        for (int i = 0 ; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j] - '0';
            }
        }
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}