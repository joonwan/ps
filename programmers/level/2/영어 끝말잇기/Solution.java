import java.util.HashSet;

class Solution {

    HashSet<String> set = new HashSet<>();

    public int[] solution(int n, String[] words) {

        set.add(words[0]);

        String beforeWord = words[0];
        int index = 1;
        int stage = 0;
        boolean flag = true;


        while (true) {

            if (index == words.length) {
                break;
            }

            if (index % n == 0) {
                stage++;
            }

            int now = index % n;
            String nowWord = words[index];


            if (!isValidWord(beforeWord, nowWord)) {
                flag = false;
                break ;
            }

            set.add(nowWord);
            beforeWord = nowWord;
            index++;
        }

        if (flag) {
            return new int[]{0, 0};
        }

        return new int[]{index % n + 1, stage + 1};


    }

    private boolean isValidWord(String before, String now) {
        if (set.contains(now)) {
            return false;
        }

        return before.charAt(before.length() - 1) == now.charAt(0);
    }
}