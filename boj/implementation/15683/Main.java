import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int map[][];
    private static int MIN;
    private static ArrayList<Cctv> cctvs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        initMap();
        recursive(0);
        System.out.println(MIN);
    }

    private static void recursive(int now) {
        if (now == cctvs.size()) {
            return ;
        }
        Cctv cctv = cctvs.get(now);
        for (int i = 0; i < cctv.rotateCount; i++) {
            cctv.spread();
            if (now + 1 == cctvs.size()) {
                checkSize();
            } else {
                recursive(now + 1);
            }
            cctv.rollBack();
            cctv.rotate();
        }

    }

    private static void checkSize() {
        int size = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    size++;
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println("min = " + MIN);
        MIN = Math.min(MIN, size);
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
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvs.add(new Cctv(i, j, map[i][j]));
                }
                if (map[i][j] == 0) MIN++;
            }
        }
    }

    static class Cctv {
        int y, x, type, rotateCount;
        // 동 남 서 북
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        ArrayList<Pointer> pointers = new ArrayList<>();
        ArrayDeque<Node> visits = new ArrayDeque<>();

        public Cctv(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;

            initPointers();
        }

        public void spread() {

            for (Pointer p : pointers) {
                int dir = p.idx;
                int tx = x + dx[dir];
                int ty = y + dy[dir];
                while (0 <= tx && tx < m && 0 <= ty && ty < n && map[ty][tx] != 6) {
                    if (map[ty][tx] == 0) {
                        map[ty][tx] = -1;
                        visits.offer(new Node(ty, tx));
                    }

                    tx += dx[dir];
                    ty += dy[dir];

                }
            }
        }

        public void rollBack() {
            while (!visits.isEmpty()) {
                Node now = visits.poll();
                map[now.y][now.x] = 0;
            }
        }


        public void rotate() {
            for (Pointer p : pointers) {
                p.add();
            }
        }

        private void initPointers() {
            if (type == 1) {
                pointers.add(new Pointer(0));
                rotateCount = 4;
            }
            if (type == 2) {
                pointers.add(new Pointer(0));
                pointers.add(new Pointer(2));
                rotateCount = 2;
            }
            if (type == 3) {
                pointers.add(new Pointer(0));
                pointers.add(new Pointer(3));
                rotateCount = 4;
            }
            if (type == 4) {
                pointers.add(new Pointer(0));
                pointers.add(new Pointer(2));
                pointers.add(new Pointer(3));
                rotateCount = 4;
            }
            if (type == 5) {
                pointers.add(new Pointer(0));
                pointers.add(new Pointer(1));
                pointers.add(new Pointer(2));
                pointers.add(new Pointer(3));
                rotateCount = 1;
            }
        }
    }

    static class Pointer {
        int idx;

        public Pointer(int idx) {
            this.idx = idx;
        }

        public void add() {
            idx = (idx + 1) % 4;
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