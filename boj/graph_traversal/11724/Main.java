import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static boolean[] visited;
    private static int result;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        for(int i = 0 ; i< n + 1; i ++) {
            graph.add(new ArrayList<Integer>());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int now) {
        visited[now] = true;

        ArrayList<Integer> nexts = graph.get(now);

        for (Integer next : nexts) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}