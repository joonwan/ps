import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] numbers;
    private static int[] water;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[m];
        water = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int max = numbers[0];
        int maxIdx = 0;

        for (int i = 1; i < m; i++) {
            int now = numbers[i];
            if (now <= max) {
                for (int j = maxIdx; j < i; j++) {
                    if (now > numbers[j]) {
                        water[j] = now - numbers[j];
                    }
                }
            } else {

                for (int j = maxIdx; j < i; j++) {
                    water[j] = max - numbers[j];
                }

                max = now;
                maxIdx = i;
            }

        }



        int result = 0;

        for (int i =0 ; i < m; i++) {
            result += water[i];
        }

        System.out.println(result);

    }
}