import java.util.HashSet;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        HashSet<String> skipSet = new HashSet<>();

        for (int i = 0; i < skip.length(); i++) {
            skipSet.add(skip.charAt(i) + "");
        }

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            int count = 0;
            while (count < index) {
                c++;
                if (c > 'z') {
                    c = (int)(c % 'z') + (int)'a' - 1;
                }

                if (!skipSet.contains((char)(c) + "")) count++;
            }

            sb.append((char)c + "");


        }

        return sb.toString();
    }
}