import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int res = sol(n);
        System.out.println(res);
    }

    private static int sol(int startValue) {
        int res = -1;
        int bigBucketCount = 0;

        while (startValue >= bigBucketCount * 5) {
            int diff = startValue - bigBucketCount * 5;
            if (diff % 3 == 0) {
                res = updateResult(diff, bigBucketCount);
            }
            bigBucketCount++;
        }

        return res;
    }

    private static int updateResult(int diff, int bigBucketCount) {
        int res;
        int smallBucketCount = diff / 3;
        res = bigBucketCount + smallBucketCount;
        return res;
    }
}