import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayDeque;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int F, S, G, U, D;
    private static int[] building;
    private static int INF = 2147483647;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        building = new int[F + 1];
        Arrays.fill(building, INF);
        building[S] = 0;
        bfs();

        if (building[G] == INF) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(building[G]);
    }

    private static void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(S);

        while (!q.isEmpty()) {
            int now = q.poll();
            int[] nexts = {now + U, now - D};

            for (int next : nexts) {
                if (next > 0 && next <= F && building[now] + 1 <  building[next]) {
                    building[next] = building[now] + 1;
                    q.offer(next);
                }
            }
        }
    }
}