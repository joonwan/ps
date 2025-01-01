import java.io.*;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static boolean[][] visited;
    private static int n;
    private static ArrayList<Integer> result = new ArrayList<>();
    private static int count;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        initMap();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        result.sort((n1, n2) -> n1 - n2);
        System.out.println(result.size());
        for (Integer res : result) {
            System.out.println(res);
        }
    }

    private static void dfs(int i, int j) {
        count++;
        visited[i][j] = true;
        for (int k = 0; k < 4; k ++) {
            int ny = i + dy[k];
            int nx = j + dx[k];

            if (0 <= ny && ny < n && 0 <= nx && nx < n) {
                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    dfs(ny, nx);
                }
            }
        }



    }

    private static void initMap() throws IOException {
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
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
