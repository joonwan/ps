import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n  = Long.parseLong(bf.readLine());
        long value = 0;
        long addValue = 1;
        long addCount = 0;

        while (value < n) {
            value += addValue++;
            addCount++;
        }

        if (value != n) {
            addCount -= 1;
        }

        System.out.println(addCount);

    }
}