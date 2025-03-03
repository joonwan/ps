import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int V, E;
    private static ArrayList<Edge> edges = new ArrayList<>();
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        long answer = 0l;
        int index = 0;
        initGraph();
        int count = 0;

        while (count < V - 1) {
            Edge e = edges.get(index);
            int p1 = getParent(e.start);
            int p2 = getParent(e.end);

            if (p1 != p2) {
                if (p1 > p2) parent[p1] = p2;
                else parent[p2] = p1;
                count++;
                answer += e.weight;
            }
            index++;
        }

        System.out.println(answer);
    }

    private static int getParent(int n) {
        if (n == parent[n]) return n;

        int result = getParent(parent[n]);
        return parent[n] = result;
    }

    private static void initGraph() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }

        edges.sort((e1, e2) -> e1.weight - e2.weight);

        parent = new int[V + 1];
        for (int i = 1; i < V + 1; i++) parent[i] = i;
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