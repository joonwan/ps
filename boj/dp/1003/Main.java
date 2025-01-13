import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static int MAX_SIZE = 41;
    private static int[] zero_arr = new int[MAX_SIZE];
    private static int[] one_arr = new int[MAX_SIZE];
    private static int n;

    public static void main(String[] args) throws IOException {

        initArr();

         n = Integer.parseInt(br.readLine());

         for (int i = 0 ; i < n ; i ++) {
             int target = Integer.parseInt(br.readLine());

             System.out.println(zero_arr[target] + " " + one_arr[target]);
         }
    }

    private static void initArr() {
        zero_arr[0] = 1;
        zero_arr[1] = 0;
        one_arr[0] = 0;
        one_arr[1] = 1;

        for (int i = 2; i < 41; i++) {
            zero_arr[i] = zero_arr[i - 1] + zero_arr[i - 2];
            one_arr[i] = one_arr[i - 1] + one_arr[i - 2];
        }

    }
}