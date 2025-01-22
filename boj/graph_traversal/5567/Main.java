import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int m;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        initGraph();

        bfs(1);

        int result = 0;
        for (int i = 2; i < n + 1; i++) {
            if (visited[i]) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void bfs(int start) {
        visited[start] = true;
        ArrayDeque<Node> q= new ArrayDeque<>();
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            int num = now.num;
            int depth = now.depth;

            ArrayList<Integer> nextNums = graph.get(num);

            for (Integer nextNum : nextNums) {
                if (!visited[nextNum] && depth + 1 <= 2) {
                    visited[nextNum] = true;
                    q.offer(new Node(nextNum, depth + 1));
                }
            }
        }
    }

    private static void initGraph() throws IOException {

        for (int i = 0 ; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
    }

    static class Node {
        int num;
        int depth;

        public Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
}