import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {

        int[] prev = new int[n];
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        boolean[] isDeleted = new boolean[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int cursor = k;

        for (String command : cmd) {
            char operation = command.charAt(0);

            switch (operation) {

                case 'U': {
                    int count = Integer.parseInt(command.substring(2));
                    while (count-- > 0) {
                        cursor = prev[cursor];
                    }
                    break;
                }

                case 'D': {
                    int count = Integer.parseInt(command.substring(2));
                    while (count-- > 0) {
                        cursor = next[cursor];
                    }
                    break;
                }

                case 'C': {
                    stack.push(cursor);
                    isDeleted[cursor] = true;

                    int previous = prev[cursor];
                    int following = next[cursor];

                    if (previous != -1) {
                        next[previous] = following;
                    }

                    if (following != -1) {
                        prev[following] = previous;
                    }

                    cursor = following != -1 ? following : previous;
                    break;
                }

                case 'Z': {
                    int restored = stack.pop();
                    isDeleted[restored] = false;

                    int previous = prev[restored];
                    int following = next[restored];

                    if (previous != -1) {
                        next[previous] = restored;
                    }

                    if (following != -1) {
                        prev[following] = restored;
                    }

                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(isDeleted[i] ? "X" : "O");
        }
        return sb.toString();
    }
}