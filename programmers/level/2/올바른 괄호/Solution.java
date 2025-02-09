import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push("(");
                continue;
            }

            if (stack.isEmpty()) {
                answer = false;
                break;
            }

            stack.pop();
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}