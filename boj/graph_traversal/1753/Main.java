import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int V, E, K;
    private static ArrayList[] graph;
    private static int MAX = 2147483647;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, MAX);
        dist[K] = 0;
        for (int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, e));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.weight - n2.weight;
        });
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            ArrayList<Node> nexts = graph[now.num];

            for (Node next : nexts) {
                int nextNode = next.num;
                int weight = next.weight;

                if (dist[nextNode] > dist[now.num] + weight) {
                    dist[nextNode] = dist[now.num] + weight;
                    pq.offer(new Node(nextNode, dist[nextNode]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V + 1; i++) {
            if (dist[i] != MAX) {
                sb.append(dist[i] + "\n");
            } else {
                sb.append("INF\n");
            }
        }

        System.out.println(sb);
    }

    static class Node {
        int num;
        int weight;

        public Node (int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

       @Override
        public String toString() {
            return "[ num = " + num + " , weigth = " + weight + " ]";
       }
    }
}