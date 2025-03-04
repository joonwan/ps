import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, k, gt; // 수 개수, 변경 회수, 구간 합을 구하는 횟수
    private static long[] tree;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // init tree
        int size = getSize();
        tree = new long[size];

        for (int i = 0 ; i < n; i++) {
            tree[getIndex(i + 1)] = Long.parseLong(br.readLine());
        }

        for (int i = (int) Math.pow(2, gt) - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        for (int i = 0; i < (m + k); i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(b, c);
            } else if (a == 2) {
                System.out.println(getSum(b, c));
            }
        }

    }

    private static void update(long index, long value) {
        int idx = getIndex(index);
        long diff = (long) value - tree[idx];

        while (idx >= 1) {
            tree[idx] += diff;
            idx /= 2;
        }
    }

    private static long getSum(long s, long e) {
        long result = 0l;
        int is = getIndex(s);
        int ie = getIndex(e);

        while (is <= ie) {
            if (is % 2 == 1) result += tree[is];
            if (ie % 2 == 0) result += tree[ie];

            is = (is + 1) / 2;
            ie = (ie - 1) / 2;
        }

        return result;
    }

    private static int getIndex(long n) {
        return (int) n + (int) Math.pow(2, gt) - 1;
    }

    private static int getSize() {
        int t = 0;

        while (Math.pow(2, t) < n) t++;

        gt = t;
        return (int) Math.pow(2, t) * 2;
    }
}