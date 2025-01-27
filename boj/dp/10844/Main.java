import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[][] graph = new long[n][10];

        for (int i = 0; i < 10; i++) {
            graph[0][i] = 1L;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    graph[i][j] = graph[i - 1][j + 1] % MOD;
                    continue;
                }

                if (j == 9) {
                    graph[i][j] = graph[i - 1][j - 1] % MOD;
                    continue;
                }

                graph[i][j] = (graph[i - 1][j + 1]%MOD + graph[i - 1][j - 1]%MOD) % MOD;
            }
        }

        long result = 0;
        for (int i = 1; i < 10; i++) {
            result += (graph[n - 1][i]) % MOD;
        }

        System.out.println(result%MOD);
    }
}