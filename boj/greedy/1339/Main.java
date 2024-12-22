import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[26];

        for (int i = 0; i < n; i++) {
            String data = bf.readLine();
            for (int j = 0; j < data.length(); j++) {
                int index = data.charAt(j) - 'A';
                arr[index] += (int) Math.pow(10, data.length() - 1 - j);
            }
        }

        int result = 0;
        Arrays.sort(arr);
        int maxNumber = 9;
        for (int i = 25; i >= 0; i--) {
            if (arr[i] == 0) {
                break;
            }

            result += maxNumber * arr[i];
            maxNumber--;
        }

        System.out.println(result);
    }
}