import java.io.*;
import java.util.ArrayList;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;
    private static ArrayList<String> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            data.add(br.readLine());
        }

        data.sort((s1, s2) -> {
            if (s1.length() == s2.length()) {
                int sum1 = getSum(s1);
                int sum2 = getSum(s2);
                if  (sum1 == sum2) {
                    return s1.compareTo(s2);
                }
                return sum1 - sum2;
            }
            return s1.length() - s2.length();
        });

        for (int i = 0 ; i <data.size(); i++) {
            System.out.println(data.get(i));
        }
    }

    private static int getSum(String s) {
        char[] arr = s.toCharArray();
        int sum = 0;

        for (int i = 0 ; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                sum += arr[i] - '0';
            }
        }

        return sum;
    }
}