import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for (int i = 0 ; i < arr.length; i++) arr[i] = i;

        for (int i = 0 ; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String mod = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int n1 = getFirstNode(a);
            int n2 = getFirstNode(b);

            if (mod.equals("0")) {
                int val = Math.min(n1, n2);
                arr[n2] = val;
                arr[n1] = val;
            } else {
                if (n1 == n2) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static int getFirstNode(int n) {
        if (n == arr[n]) return n;
        int val = arr[n];
        int head = getFirstNode(val);
        arr[n] = head;
        return head;
    }
}