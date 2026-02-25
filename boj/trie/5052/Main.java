import java.io.*;

public class Main {

    private static final int MAX_NODE = 100_001;
    private static final int MAX_NUMBER = 10;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int tc, n, nodeCnt;
    private static int[][] table = new int[MAX_NODE][MAX_NUMBER];
    private static boolean[] isEnd = new boolean[MAX_NODE];
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] agrs) throws IOException {
        tc = Integer.parseInt(br.readLine());
        
        // O(tc * n * m)
        for (int i = 0; i < tc; i++) {
            sol();
        }

        System.out.print(sb);
    }

    private static void sol() throws IOException {

        init();
        n = Integer.parseInt(br.readLine());
        boolean isConsistent = true;

        // O(n * m)
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            
            if (isConsistent) {
                if (!insert(word)) {
                    isConsistent = false;
                }
            }
        }

        sb.append(isConsistent ? "YES\n" : "NO\n");
    }

    // O(m) m = length of word
    private static boolean insert(String word) {
        int curr = 0; // root node

        for (int i = 0; i < word.length(); i++) {
            int child = word.charAt(i) - '0';

            if (table[curr][child] == 0) {
                table[curr][child] = ++nodeCnt;
            }

            // move next node
            curr = table[curr][child];

            if (isEnd[curr]) return false;
        }

        for (int i = 0; i < MAX_NUMBER; i++) {
            if (table[curr][i] != 0) return false;
        }

        // end of word
        isEnd[curr] = true;
        return true;
    }

    private static void init() {
        for (int i = 0; i <= nodeCnt; i++) {
            for (int j = 0; j < MAX_NUMBER; j++) {
                table[i][j] = 0;
            }
            isEnd[i] = false;
        }

        nodeCnt = 0;
    }
}
