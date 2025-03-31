import java.util.StringTokenizer;
import java.io.*;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, count;
    private static int[] arr;
    private static int[] combi;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int size = 1;  size < n + 1; size++) {

            combi = new int[size];
            for (int start = 0; start < n - size + 1; start++) {
                recursive(start, 0);
            }
        }

        System.out.println(count);
    }

    private static void recursive(int idx, int depth) {
        combi[depth] = arr[idx];

        if (depth + 1 == combi.length) {
            check();
            return ;
        }

        for (int i = idx + 1; i < arr.length; i++) {
            recursive(i, depth + 1);
        }
    }

    private static void check() {
         int sum = Arrays.stream(combi).reduce(0, (a, b) -> a + b);
         if (sum == m) {
             count++;
         }
    }
}