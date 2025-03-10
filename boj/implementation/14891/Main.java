import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Chain[] chains = new Chain[4];
    private static boolean[] visited;
    private static int[] scores = {1, 2, 4, 8};

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 4; i++) {
            chains[i] = new Chain(br.readLine());
        }

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            visited = new boolean[4];
            rotate(idx - 1, dir);
        }

        int result = 0;
        for (int i = 0 ; i < 4; i++) {
            int type = chains[i].getTopValue();
            if (type == 1) {
                result += scores[i];
            }
        }
        System.out.println(result);
    }

    private static void rotate(int idx, int dir) {
        visited[idx] = true;
        if (idx < 3 && chains[idx].getRightValue() != chains[idx + 1].getLeftValue() && !visited[idx + 1]) {
            rotate(idx + 1, dir * -1);
        }

        if (idx > 0 && chains[idx].getLeftValue() != chains[idx - 1].getRightValue() && !visited[idx - 1]) {
            rotate(idx - 1, dir * -1);
        }
        chains[idx].rotate(dir);
    }

    static class Chain {

        int[] types = new int[8];
        int leftIdx, rightIdx, topIdx;

        public Chain(String data) {
            for (int i = 0; i < data.length(); i++) {
                types[i] = data.charAt(i) - '0';
            }
            rightIdx = 2;
            leftIdx = 6;
            topIdx = 0;
        }

        public void print() {
            System.out.println(Arrays.toString(types));
        }

        public int getLeftValue() {
            return types[leftIdx];
        }

        public int getRightValue() {
            return types[rightIdx];
        }

        public int getTopValue() {
            return types[topIdx];
        }

        private void rotate(int dir) {
            if (dir == 1) {
                clockWise();
                return;
            }
            counterClockWise();
        }

        private void clockWise() {
            int tmp = types[7];
            for (int i = 6 ; i >= 0; i--) {
                types[i + 1] = types[i];
            }
            types[0] = tmp;
        }

        private void counterClockWise() {
            int tmp = types[0];
            for (int i = 0; i < 7; i++) {
                types[i] = types[i + 1];
            }
            types[7] = tmp;
        }
    }
}