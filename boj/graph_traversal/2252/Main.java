import java.util.ArrayList;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] arr;
    private static int[] result;
    private static boolean[] visited;
    private static ArrayList[] graph;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        result = new int[n + 1];
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        int index = 0;

        for (int i = 1; i < n + 1; i++) graph[i] = new ArrayList<Integer>();

        for (int i = 0 ; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            arr[b]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        setZero(q);

        while (!q.isEmpty()) {
            int now = q.poll();
            result[++index] = now;
            ArrayList<Integer> nexts = graph[now];

            for (int next : nexts) {
                arr[next]--;
                if (arr[next] == 0) {
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i] + " ");
        }

        System.out.println(sb);
    }

    private static void setZero(ArrayDeque<Integer> q) {
        for (int i = 1; i < n + 1; i++) {
            if (arr[i] == 0) {
                q.offer(i);
            }
        }
    }
}