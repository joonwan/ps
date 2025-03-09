import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, y, x;
    private static int[][] map;

    public static void main(String[] agrs) throws IOException {

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    y = i;
                    x = j;
                }
            }
        }

        Shark shark = new Shark(y, x);
        int time = 0;
        while (shark.operate) {
            time += shark.move();
        }
        System.out.println(time);
    }

    static class Shark {
        int y, x, size, eatCount;
        boolean operate;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        public Shark(int y, int x) {
            this.y = y;
            this.x = x;
            this.size = 2;
            operate = true;
        }

        public int move() {

            ArrayList<Node> fishes = findFishes();
            if (fishes.isEmpty()) {
                operate = false;
                return 0;
            }
            int fy = 0;
            int fx = 0;
            int result = 2147483647;
            if (fishes.size() != 1) {
                for (Node fish : fishes) {
                    if (result > fish.dist) {
                        result = fish.dist;
                        fy = fish.y;
                        fx = fish.x;
                    } else if (result == fish.dist) {
                        if (fy > fish.y) {
                            result = fish.dist;
                            fy = fish.y;
                            fx = fish.x;
                        } else if (fy == fish.y) {
                           if (fx > fish.x) {
                               result = fish.dist;
                               fy = fish.y;
                               fx = fish.x;
                           }
                        }
                    }
                }
            } else {
                Node fish = fishes.get(0);
                fy = fish.y;
                fx = fish.x;
                result = fish.dist;
            }
            map[y][x] = 0;
            y = fy;
            x = fx;
            map[y][x] = 9;
            eatCount++;
            if (eatCount == size) {
                eatCount = 0;
                size++;
            }
            return result;
        }

        private ArrayList<Node> findFishes() {
            ArrayList<Node> result = new ArrayList<>();
            ArrayDeque<Node> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][n];
            visited[y][x] = true;
            q.offer(new Node(y, x, 0));

            while (!q.isEmpty()) {
                Node now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[ny][nx]) {
                        if (map[ny][nx] <= size) {
                            Node next = new Node(ny, nx, now.dist + 1);
                            visited[ny][nx] = true;
                            q.offer(next);
                            if (map[ny][nx] < size && map[ny][nx] != 0) result.add(next);
                        }
                    }
                }
            }
            return result;
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

        @Override
        public String toString() {
            return "[ y = " + y + " x = " + x + " dist = " + dist + " ]";
        }
    }
}