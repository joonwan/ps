import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] nums;
    private static int[] acc;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        acc = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        acc[0] = nums[0];
        int max = acc[0];

        for (int i = 1; i < n; i++) {
            acc[i] = Math.max(acc[i - 1] + nums[i], nums[i]);
            max = Math.max(acc[i], max);
        }


        System.out.println(max);
    }
}