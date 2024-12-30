import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int n, m, v;
    private static boolean[] visited;
    private static StringBuilder sb1 = new StringBuilder();
    private static StringBuilder sb2 = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        initGraph();

        visited = new boolean[n + 1];

        dfs(v);

        Arrays.fill(visited, false);

        bfs(v);

        System.out.println(sb1);
        System.out.println(sb2);
    }

    private static void initGraph() throws IOException {
        StringTokenizer st;
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        for (ArrayList<Integer> list : graph) {
            list.sort((n1, n2) -> n1 - n2);
        }
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb1.append(v).append(" ");

        ArrayList<Integer> nextNodes = graph.get(v);
        for (Integer next : nextNodes) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int v) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(v);

        while (!q.isEmpty()) {

            int now = q.poll();
            visited[now] = true;
            sb2.append(now).append(" ");

            ArrayList<Integer> nextNodes = graph.get(now);

            for (Integer next : nextNodes) {
                if (!visited[next] && !q.contains(next)) {
                    q.offer(next);
                }
            }
        }
    }
}