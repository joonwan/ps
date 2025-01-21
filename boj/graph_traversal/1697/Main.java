import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayDeque;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int k;
    private static int INF = 2147483647;
    private static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(arr, INF);
        arr[n] = 0;

        bfs(n);

//        System.out.println(Arrays.toString(arr));
        System.out.println(arr[k]);
    }

    private static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            int[] nexts = {now - 1, now + 1, 2 * now};

            for (int i = 0; i < 3; i++) {
                int next = nexts[i];

                if (0 <= next && next < arr.length && arr[next] > arr[now] + 1) {
                    arr[next] = arr[now] + 1;
                    q.offer(next);
                }
            }
        }
    }

}