class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        
        int[] result = new int[n];
        int count = n;
        
        for (int i = 0; i < count; i++) {
            result[i] = s / n;
            s -= result[i];
            n--;
        }
        
        return result;
    }
}