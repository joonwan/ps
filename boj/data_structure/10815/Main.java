import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static HashSet<Integer> set = new HashSet<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (set.contains(number)) {
                sb.append(1);
            } else {
                sb.append(0);
            }

            sb.append(" ");
        }

        System.out.println(sb);
    }
}