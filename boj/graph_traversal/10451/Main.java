import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            sol();
        }
    }

    private static void sol() throws IOException {
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size + 1];
        boolean[] visited = new boolean[size + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int i = 1; i <= size; i++) {
            if (!visited[i]) {
                dfs(i, arr, visited);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int now, int[] arr, boolean[] visited) {
        visited[now] = true;

        if (!visited[arr[now]]) {
            dfs(arr[now], arr, visited);
        }
    }
}