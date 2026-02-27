import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<ArrayList<int[]>> graph;
    private static int[] dist;
    private static int V, E, K;
    private static StringTokenizer st;

    public static void main(String[] agrs) throws IOException {
        init();
        dijkstra();
        printResult();
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
        }

        System.out.print(sb);
    }

    private static void dijkstra() {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        heap.offer(new int[]{K, 0});

        while (!heap.isEmpty()) {
            int[] now = heap.poll();
            int node = now[0], cost = now[1];

            if (cost > dist[node]) continue;

            for (int[] next : graph.get(node)) {
                int ncost = cost + next[1];
                if (ncost < dist[next[0]]) {
                    dist[next[0]] = ncost;
                    heap.offer(new int[]{next[0], ncost});
                }
            }
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, w});
        }

        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[K] = 0;
    }
}
