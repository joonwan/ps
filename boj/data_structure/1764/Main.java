import java.io.*;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;


public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(bf.readLine());
        }

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String name = bf.readLine();
            if (set.contains(name)) {
                result.add(name);
            }
        }

        System.out.println(result.size());

        result.sort((s1, s2) -> s1.compareTo(s2));

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}