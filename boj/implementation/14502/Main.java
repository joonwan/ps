import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] map;
    private static ArrayList<Node> emptySpaces = new ArrayList<>();
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int result = 0;

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    emptySpaces.add(new Node(i, j));
                }
            }
        }

        int size = emptySpaces.size();
        for (int i = 0 ; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    setWall(i, j,k);
                    result = Math.max(result, getSafeAreaSize());
                    rollback(i, j, k);
                }
            }
        }
        System.out.println(result);
    }

    private static void setWall(int i, int j, int k) {
        Node n1 = emptySpaces.get(i);
        Node n2 = emptySpaces.get(j);
        Node n3 = emptySpaces.get(k);

        map[n1.y][n1.x] = 1;
        map[n2.y][n2.x] = 1;
        map[n3.y][n3.x] = 1;

    }

    private static int getSafeAreaSize() {
        ArrayList<Node> spreadedNode = new ArrayList<>();
        int result = 0;

        for (int i = 0 ;i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    spread(i, j, spreadedNode);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    result++;
                }
            }
        }

        for (Node node : spreadedNode) {
            map[node.y][node.x] = 0;
        }

        return result;
    }

    private static void spread(int y, int x, ArrayList<Node> spreadedNode) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        visited[y][x] = true;
        q.offer(new Node(y, x));

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0 ; i < 4; i ++) {
                int ny = dy[i] + now.y;
                int nx = dx[i] + now.x;

                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if (!visited[ny][nx] && map[ny][nx] == 0) {
                        Node next = new Node(ny, nx);
                        visited[ny][nx] = true;
                        map[ny][nx] = 2;
                        q.offer(next);
                        spreadedNode.add(next);
                    }
                }
            }
        }

    }

    private static void spread(ArrayList<Node> spreadedNode) {
        ArrayDeque<Node> q = new ArrayDeque<>();
    }

    private static void rollback(int i, int j, int k) {
        Node n1 = emptySpaces.get(i);
        Node n2 = emptySpaces.get(j);
        Node n3 = emptySpaces.get(k);

        map[n1.y][n1.x] = 0;
        map[n2.y][n2.x] = 0;
        map[n3.y][n3.x] = 0;
    }

    static class Node {
        int y;
        int x;

        public Node (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
