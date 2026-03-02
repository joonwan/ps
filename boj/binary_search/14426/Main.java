import java.io.*;
import java.util.*;

// binary search L * N * M * Log(N)
public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static ArrayList<String> words;

    public static void main(String[] args) throws IOException {
        
        init();
        sol();
    }

    private static void sol() throws IOException {
        int prefixCount = 0;

        for (int i = 0; i < m; i++) {
            if (isPrefix(br.readLine())) {
                prefixCount++;
            }
        }

        System.out.println(prefixCount);
    }

    private static boolean isPrefix(String word) {
        int s = 0;
        int e = words.size() - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            String data = words.get(mid);

            if (data.startsWith(word)) return true;

            if (word.compareTo(data) < 0) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return false;
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }

        words.sort(String::compareTo);
    }    
    
}
