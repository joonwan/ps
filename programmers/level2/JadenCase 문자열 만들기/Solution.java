class Solution {
    public String solution(String s) {

        char[] arr = s.toLowerCase().toCharArray();

        if (isAlphabet(arr[0])) {
            arr[0] -= 32;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (Character.isSpaceChar(arr[i]) && isAlphabet(arr[i + 1])) {
                arr[i + 1] -= 32;
            }
        }

        return new String(arr);
    }

    private boolean isAlphabet(char c) {
        return 'a' <= c && c <= 'z';
    }
}