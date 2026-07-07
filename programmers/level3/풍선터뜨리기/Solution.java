
class Solution {
    public int solution(int[] a) {
        int answer = a.length;
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];

        leftMin[0] = a[0];
        rightMin[a.length - 1] = a[a.length - 1];

        for (int i = 1; i < a.length; i++) {
            leftMin[i] = Math.min(a[i], leftMin[i - 1]);
        }

        for (int i = a.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(a[i], rightMin[i + 1]);
        }

        for (int i = 0; i < a.length; i++) {
            if (leftMin[i] < a[i] && a[i] > rightMin[i]) {
                answer--;
            }
        }
        return answer;
    }
}