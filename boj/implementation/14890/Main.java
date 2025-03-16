import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static int[][] map;
    private static int count;
    private static boolean[] visited;

    public static void main(String[] agrs) throws IOException {
        initMap();

        for (int i = 0; i < n; i++) {
            checkHori(i);
            checkVerti(i);
        }

        System.out.println(count);
    }

    private static void checkHori(int r) {

        visited = new boolean[n];
        int idx = 0;

        while (idx < n - 1) {
            int nowVal = map[r][idx];
            int nextVal = map[r][idx + 1];

            if (nowVal == nextVal) {
                idx++;
                continue;
            } else if (Math.abs(nowVal - nextVal) != 1) {
                return ;
            }

            int start = 0;
            int end = 0;
            int dir = 0;
            if (nowVal > nextVal) {
                start = idx;
                end = idx + 1;
                dir = 1;
            } else {
                start = idx + 1;
                end = idx;
                dir = -1;
            }

            int length = 0;
            while (0 <= end && end < n && length < k && !visited[end]) {
                visited[end] = true;
                length++;
                if (end + dir >= 0 && end + dir < n && map[r][end] == map[r][end + dir]) {
                    end += dir;
                } else {
                    break ;
                }
            }
            if (length < k) {
                return ;
            }
            idx ++;
        }

        count++;
    }

    private static void checkVerti(int c) {
        visited = new boolean[n];
        int idx = 0;

        while (idx < n - 1) {
            int nowVal = map[idx][c];
            int nextVal = map[idx + 1][c];

            if (nowVal == nextVal) {
                idx++;
                continue;
            } else if (Math.abs(nowVal - nextVal) != 1) {
                return ;
            }

            int start = 0;
            int end = 0;
            int dir = 0;
            if (nowVal > nextVal) {
                start = idx;
                end = idx + 1;
                dir = 1;
            } else {
                start = idx + 1;
                end = idx;
                dir = -1;
            }

            int length = 0;
            while (0 <= end && end < n && length < k && !visited[end]) {
                visited[end] = true;
                length++;

                if (end + dir >= 0 && end + 1 < n && map[end][c] == map[end + dir][c]) {
                    end += dir;
                } else {
                    break ;
                }
            }

            if (length < k) {
                return ;
            }

            idx ++;
        }

        count++;
    }



    private static void initMap() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}