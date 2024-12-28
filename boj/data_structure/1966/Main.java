import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayDeque<Node> q = new ArrayDeque<>();
    private static PriorityQueue<Integer> weights = new PriorityQueue<>((n1, n2) -> n2 - n1);

    public static void main(String[] args) throws IOException{
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < tc; i++) {
            sol();
        }
    }

    private static void sol() throws IOException {
        q.clear();
        weights.clear();

        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(st.nextToken());
            q.offer(new Node(i, weight));
            weights.offer(weight);
        }

        while (!q.isEmpty()) {
            int nextWeight = weights.poll();

            while (true) {
                Node node = q.poll();

                if (node == null) {
                    break;
                }

                if (node.weight != nextWeight) {
                    q.offer(node);
                } else {
                    count++;
                    if (node.compareIndex(m)) {
                        System.out.println(count);
                    }
                    break;
                }
            }
        }
    }

    static class Node {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        public boolean compareIndex(int index) {
            return this.index == index;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "Node{" +
                    "index=" + index +
                    ", weight=" + weight +
                    '}';
        }
    }
}