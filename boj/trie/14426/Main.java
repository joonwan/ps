import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX_NODE = 10_000 * 500 + 5;
    private static final int ALPHABET_COUNT = 26;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, nodeCount;
    private static int[][] trie;
    private static boolean[] isEnd;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void sol() throws IOException {
        int prefixCount = 0;

        for (int i = 0; i < n; i++) {
            input(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            if (isPrefix(br.readLine())) prefixCount++;
        }

        System.out.println(prefixCount);

    }

    private static void input(String word) {
        int curr = 0; // root
        
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (trie[curr][idx] == 0) {
                trie[curr][idx] = ++nodeCount;
            }

            curr = trie[curr][idx];
        }

        isEnd[curr] = true;
    }   

    private static boolean isPrefix(String word) {

        int curr = 0; // root

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (trie[curr][idx] == 0) {
                return false;
            }

            curr = trie[curr][idx];
        }

        return true;
    }

    private static void init() throws IOException {

        trie = new int[MAX_NODE][ALPHABET_COUNT];
        isEnd = new boolean[MAX_NODE];
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
    }
}
