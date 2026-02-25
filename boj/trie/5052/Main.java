import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int tc, n;
    private static ArrayList<String> numbers;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            if (!sol()) sb.append("NO\n");
            else sb.append("YES\n");
        }

        System.out.print(sb);
    }

    private static boolean sol() throws IOException {
        init();
        Trie trie = new Trie();

        for (String phoneNumber : numbers) {
            if (trie.startsWith(phoneNumber)) return false;
            trie.insert(phoneNumber);
        }

        return true;
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(br.readLine());
        }

        numbers.sort((s1, s2) -> s2.compareTo(s1));
    }

    static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;

            for (char c : word.toCharArray()) {
                if (!node.containsKey(c)) node.put(c, new Node());
                node = node.get(c);
            }

            node.setEnd();
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Node searchPrefix(String prefix) {
            Node node = root;

            for (char c : prefix.toCharArray()) {
                if (!node.containsKey(c)) return null;
                node = node.get(c);
            }

            return node;
        }
    }

    static class Node {
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord = false;

        public boolean containsKey(char c) {
            return children.containsKey(c);
        }

        public Node get(char c) {
            return children.get(c);
        }

        public void put(char c, Node child) {
            children.put(c, child);
        }

        public void setEnd() {
            isEndOfWord = true;
        }

    }
}
