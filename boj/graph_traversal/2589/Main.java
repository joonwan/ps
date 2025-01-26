import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int height, width;
    private static int[][] graph;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        initGraph();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (graph[i][j] == 1) {
                    result = Math.max(bfs(i, j), result);
                }
            }
        }

        System.out.println(result);
    }

    private static int bfs(int y, int x) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[height][width];
        visited[y][x] = true;
        q.offer(new Node(y, x, 0));

        int max = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (0 <= nx && nx < width && 0 <= ny && ny < height) {
                    if (!visited[ny][nx] && graph[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        q.offer(new Node(ny, nx, now.dist + 1));
                        max = Math.max(max, now.dist + 1);
                    }
                }
            }
        }
        return max;
    }

    private static void initGraph() throws IOException {
        graph = new int[height][width];

        for (int i = 0; i < height; i++) {
            char[] data = br.readLine().toCharArray();

            for (int j = 0; j < width; j++) {
                if (data[j] == 'L') {
                    graph[i][j] = 1;
                } else {
                    graph[i][j] = 0;
                }
            }
        }
    }

    static class Node {
        int y;
        int x;
        int dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}