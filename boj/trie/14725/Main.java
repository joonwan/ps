import java.io.*;
import java.util.*;

public class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static Node root;


    public static void main(String[] args) throws IOException {
        init();
        makeResult(root, 0);
        System.out.print(sb);
    }

    private static void makeResult(Node node, int level) {
        
        for (String data : node.children.keySet()) {
            sb.append("--".repeat(level)).append(data).append("\n");
            makeResult(node.children.get(data), level + 1);
        }

    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        root = new Node();

        for (int i = 0; i < n; i++) {
            Node curr = root;

            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                String data = st.nextToken();
                
                if (!curr.children.containsKey(data)) {
                    curr.children.put(data, new Node());
                } 

                curr = curr.children.get(data);
            }
        }

    }

    static class Node {
        TreeMap<String, Node> children = new TreeMap<>();
    }
}
