import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int count = 1;
        while (end > start) {
            String num = String.valueOf(end);
            if (end % 2 == 0) {
                end /= 2;
            } else if (num.charAt(num.length() - 1) == '1') {
                end /= 10;
            } else {
                break;
            }
            count++;
        }

        if (end == start) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}