import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bf.readLine());

        long[] nums = getArray(n);
        Arrays.sort(nums);

        int m = Integer.parseInt(bf.readLine());
        long[] targets = getArray(m);

        for (int i = 0; i < targets.length; i++) {
            long target = targets[i];
            System.out.println(binarySearch(nums, target, 0, nums.length - 1));
        }
    }

    private static long[] getArray(int size) throws IOException {
        long[] nums = new long[size];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < size; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        return nums;
    }

    private static int binarySearch(long[] nums, long target, int start, int end) {

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            return 1;
        }

        int nextStart = start;
        int nextEnd = end;

        if (target < nums[mid]) {
            nextEnd = mid - 1;
        }

        if (target > nums[mid]) {
            nextStart = mid + 1;
        }

        if (nextStart > nextEnd) {
            return 0;
        }

        return binarySearch(nums, target, nextStart, nextEnd);
    }
}