class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, getLenOfPalindrome(s, i, i));
            answer = Math.max(answer, getLenOfPalindrome(s, i, i + 1));
        }

        return answer;
    }

    private int getLenOfPalindrome(String str, int s, int e) {
        int len = 0;

        while (true) {
            if (0 > s || e >= str.length() || str.charAt(s) != str.charAt(e))
                break;
            if (str.charAt(s) == str.charAt(e)) {
                len = e - s + 1;
                s--;
                e++;
            }
        }

        return len;
    }
}