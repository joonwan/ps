import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            sol();
        }
    }

    private static void sol() throws IOException {
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> ranks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ranks.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        ranks.sort((ri1, ri2) -> ri1.r1 - ri2.r1);

        int count = 1;

        int max = ranks.get(0).r2;
        for (int i = 1; i < n; i++) {
            Node now = ranks.get(i);

            if (now.r2 < max) {
                count++;
                max = now.r2;
            }
        }

        System.out.println(count);
    }


    static class Node {
        int r1;
        int r2;

        public Node(int r1, int r2) {
            this.r1 = r1;
            this.r2 = r2;
        }

    }
}
