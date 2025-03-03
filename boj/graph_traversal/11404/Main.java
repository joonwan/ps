import java.util.StringTokenizer;
import java.io.*;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static long[][] graph;
    private static long INF = 2147483647;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        initGraph();
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    graph[s][e] = Math.min(graph[s][e], graph[s][k] + graph[k][e]);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 1; j < n + 1; j++) {
                if (graph[i][j] == INF) {
                    sb.append(0 + " ");
                } else {
                    sb.append(graph[i][j] + " ");
                }
            }

            result.append(sb.toString() + "\n");
        }

        System.out.println(result);
    }

    private static void initGraph() throws IOException {
        graph = new long[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s][e] = Math.min(graph[s][e], w);
        }
    }
}