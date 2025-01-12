import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;
    private static int[] arr;
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    private static HashMap<Integer, Integer> map = new HashMap<>();
    private static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int number = 0;
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        for (Integer e : set) {
            pq.offer(e);
        }

        while (!pq.isEmpty()) {
            map.put(pq.poll(), number++);
        }

        for (int i = 0; i < n; i++) {
            bw.write(map.get(arr[i]) + " ");
        }

        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}