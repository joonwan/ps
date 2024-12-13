import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        Integer[] ropes = new Integer[n];
        Integer[] result = new Integer[n];
        int maxValue = 0;

        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(ropes, (n1, n2) -> n2 - n1);

        if (n == 1) {
            System.out.println(ropes[0]);
            return;
        }

        result[0] = ropes[0];
        for (int i = 1; i < n; i++) {
            result[i] = ropes[i] * (i + 1);
        }

        for(int i = 0 ; i < n; i ++) {
            maxValue = Math.max(maxValue, result[i]);
        }

        System.out.println(maxValue);
    }
}