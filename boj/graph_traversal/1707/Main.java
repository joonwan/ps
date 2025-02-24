import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static String YES = "YES";
    private final static String NO = "NO";
    private static int V, E;
    private static ArrayList<Integer>[] graph;
    private static boolean isEven;
    private static boolean[] visited;
    private static int[] group;

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) sol();
    }

    private static void sol() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) graph[i] = new ArrayList<Integer>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[v].add(e);
            graph[e].add(v);

        }

        isEven = true;
        visited = new boolean[V + 1];
        group = new int[V + 1];
        for (int i = 1; i < V + 1 && isEven; i++) {
            if (!visited[i]) dfs(i);
        }

        if (isEven) {
            System.out.println(YES);
            return;
        }

        System.out.println(NO);
    }

    private static void dfs(int i) {
        ArrayList<Integer> nexts = graph[i];
        visited[i] = true;

        for (int next : nexts) {
            if (!visited[next]) {
                group[next] = (group[i] + 1) % 2;
                dfs(next);
            } else {
                if (group[next] == group[i]) {
                    isEven = false;
                    return ;
                }
            }
        }
    }
}