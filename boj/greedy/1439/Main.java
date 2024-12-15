import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        int zeroGroupCount = getGroupCount(input, 1);
        int oneGroupCount = getGroupCount(input, 0);

        System.out.println(Math.min(zeroGroupCount, oneGroupCount));
    }

    private static int getGroupCount(String input, int number) {
        String target = number + "";
        int count = 0;
        StringTokenizer st = new StringTokenizer(input, target);

        while (st.hasMoreTokens()) {
            count++;
            st.nextToken();
        }

        return count;
    }
}