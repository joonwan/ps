import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, L, R;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        initEnv();

        int round = 0;
        while (true) {
            boolean isOpen = open();
            if (!isOpen) {
                break;
            }
            round++;
            rollback();
        }

        System.out.println(round);
    }

    private static boolean open() {

        boolean isOpen = false;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && canMove(i, j)) {
                    isOpen = true;
                    ArrayList<Node> movedNodes = new ArrayList<>();
                    int eachvalue = bfs(i, j, movedNodes);
                    move(movedNodes, eachvalue);
                }
            }
        }

        return isOpen;
    }

    private static void move(ArrayList<Node> movedNodes, int eachValue) {
        for (Node now : movedNodes) {
            graph[now.y][now.x] = eachValue;
        }
    }

    private static boolean canMove(int y, int x) {
        boolean flag = false;

        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
                int diff = Math.abs(graph[ny][nx] - graph[y][x]);
                if (L <= diff && diff <= R) {
                    flag = true;
                }
            }
        }

        return flag;
    }

    private static int bfs(int y, int x, ArrayList<Node> movedNodes) {
        visited[y][x] = true;
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(y, x));

        int sum = 0;
        int count = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();
            movedNodes.add(now);
            sum += graph[now.y][now.x];
            count++;

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
                    int diff = Math.abs(graph[ny][nx] - graph[now.y][now.x]);
                    if (L <= diff && diff <= R) {
                        visited[ny][nx] = true;
                        q.offer(new Node(ny, nx));
                    }
                }
            }
        }

        return (int) Math.floor(sum / count);

    }

    private static void rollback() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static void initEnv() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
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