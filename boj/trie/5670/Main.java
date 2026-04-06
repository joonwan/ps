import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static double result;
    private static Trie trie;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
    
        while (input != null) {
            n = Integer.parseInt(input);
            result = 0;
            trie = new Trie();

            for (int i = 0; i < n; i++) {
                trie.insert(br.readLine());
            }

            dfs(trie.root, 0, 0);
            
            System.out.printf("%.2f\n", (result / n));
            input = br.readLine();
        }
    }

    private static void dfs(Node curr, int clickCount, int depth) {

        if (curr.isEnd) {
            result += clickCount;
        }

        HashMap<Character, Node> children = curr.children;

        int nextClickCount = clickCount;
        if (children.size() >= 2 || (children.size() == 1 && curr.isEnd) || depth == 0) nextClickCount++;

        for (Character c : children.keySet()) {
            dfs(children.get(c), nextClickCount, depth + 1);
        }
    }
    

    static class Trie {
        Node root = new Node();

        public void insert(String word) {

            Node curr = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (!curr.contains(c)) {
                    curr.put(c);
                }

                curr = curr.get(c);
            }

            curr.isEnd = true;
        }
    }

    static class Node {
        HashMap<Character, Node> children = new HashMap<>();
        boolean isEnd;

        public boolean contains(char c) {
            return children.containsKey(c);
        }

        public void put(char c) {
           children.put(c, new Node());
        }

        public Node get(char c) {
            return children.get(c);
        }
        
        public void setEnd() {
            this.isEnd = true;
        }
    }
}