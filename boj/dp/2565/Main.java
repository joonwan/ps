import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Line> lines = new ArrayList<>();
    private static int n;
    private static int[] dp = new int[501];
    private static int[] maxVal = new int[501];

    public static void main(String[] agrs) throws IOException {
        n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            lines.add(new Line(br.readLine()));
        }
        lines.sort((l1, l2) -> l1.start - l2.start);

        for (int i = 1; i < n + 1; i++) {
            Line line = lines.get(i - 1);
            maxVal[i] = line.end;
            for (int j = 0; j < line.start; j++) {
                if (line.end > maxVal[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(dp[i], result);
        }


        System.out.println(n - result);
    }

    static class Line {
        int start, end;

        public Line(String data) {
            StringTokenizer st = new StringTokenizer(data);
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
        }
    }
}