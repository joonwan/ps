import java.util.Arrays;

class Solution {

    boolean[] isPrime = new boolean[50001];
    int[] arr = new int[3];
    int result;

    public int solution(int[] nums) {
        initPrimeNumber();
        System.out.println(isPrime[8]);

        for (int i = 0 ; i <= nums.length - 3; i++) {
            recursive(i, 0, nums);
        }
        return result;
    }

    private void recursive(int now, int count, int[] nums) {
        arr[count] = nums[now];
        if (count == 2) {
            validate();
            return ;
        }

        for (int i = now + 1; i < nums.length; i++) {
            recursive(i, count + 1, nums);
        }
    }

    private void validate() {


        int sum = 0;

        for (int i = 0 ; i < 3; i++) {
            sum += arr[i];
        }

        if (isPrime[sum]) {

            result++;
        }
    }

    private void initPrimeNumber() {

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < 50001; i++) {
            if (isPrime[i]) {
                for (int j = i; i + j < 50001; j += i) {
                    isPrime[i + j] = false;
                }
            }
        }
    }
}