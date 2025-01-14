import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static int MAX_SIZE = 101;
    private static long[] arr = new long[MAX_SIZE];

    public static void main(String[] args) throws IOException {
        initArr();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(arr[num]);
        }
    }

    private static void initArr() {
        arr[1] = arr[2] = arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        arr[6] = 3;
        arr[7] = 4;
        arr[8] = 5;
        for (int i =9; i < MAX_SIZE; i++) {
            arr[i] = arr[i - 5] + arr[i - 1];
        }
    }
}