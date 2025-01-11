import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr = new int[5];

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 ; j++) {
                int num1 = arr[j];
                int num2 = arr[j + 1];
                if (num1 > num2) {
                    int tmp = num1;
                    arr[j] = num2;
                    arr[j + 1] = tmp;
                    print();
                }
            }
        }

        bw.flush();
    }

    private static void print() throws IOException {
        for (int i = 0; i < 5; i++) {
            bw.write(arr[i] + " ");
        }
        bw.write("\n");
    }
}