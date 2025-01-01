import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int count;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        initGraph();

        bfs();

        System.out.println(count);
    }

    private static void bfs() {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        visited[1] = true;
        dq.offer(1);

        while (!dq.isEmpty()) {
            int now = dq.poll();

            ArrayList<Integer> nexts = graph.get(now);
            for (Integer next : nexts) {
                if (!visited[next]) {
                    count++;
                    dq.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    private static void initGraph() throws IOException {
        for (int i = 0 ; i < n + 1; i ++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            graph.get(c1).add(c2);
            graph.get(c2).add(c1);

        }
    }
}