import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static ArrayList<Edge> edges;
    private static long[] dist;
    private static int INF = 59999999;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        initEdges();

        for (int i = 0; i < n - 1; i++) {
            updateDistance();
        }

        if (hasNegativeCycle()) {
            System.out.println(-1);
            return ;
        }

        for (int i = 2; i < n + 1; i ++) {
            if (dist[i] == INF) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    private static boolean hasNegativeCycle() {
        for (Edge e : edges) {
            if (dist[e.start] != INF) {
                long nextVal = Math.min(dist[e.end], dist[e.start] + e.weight);
                if (nextVal < dist[e.end]) return true;
            }
        }
        return false;
    }

    private static void updateDistance() {
        for (Edge e : edges) {
            if (dist[e.start] != INF) {
                dist[e.end] = Math.min(dist[e.end], dist[e.start] + e.weight);
            }
        }
    }

    private static void initEdges() throws IOException {
        edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Edge e = new Edge(start, end, weight);

            edges.add(e);
        }
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}