import java.util.Arrays;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] count = new int[n];
        int[] last = new int[n];

        Arrays.fill(last, -2);
        int maxPairCount = 0;

        for (int i = 0; i < n - 1; i++) {
            int left = a[i];
            int right = a[i + 1];

            if (left == right)
                continue;

            if (i - last[left] >= 2) {
                count[left]++;
                last[left] = i;

                maxPairCount = Math.max(
                        maxPairCount,
                        count[left]);
            }

            if (i - last[right] >= 2) {
                count[right]++;
                last[right] = i;

                maxPairCount = Math.max(
                        maxPairCount,
                        count[right]);
            }
        }
        return maxPairCount * 2;
    }
}