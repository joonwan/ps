import java.util.*;

class Solution {

    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);

            char cmd = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if (cmd == 'I') {
                map.put(num, map.getOrDefault(num, 0) + 1);
                continue;
            }

            if (cmd == 'D') {
                if (map.isEmpty())
                    continue;

                int target = num == 1 ? map.lastKey() : map.firstKey();
                int count = map.get(target);

                if (count == 1)
                    map.remove(target);
                else
                    map.put(target, count - 1);
            }
        }

        if (map.isEmpty()) {
            return new int[] { 0, 0 };
        }

        return new int[] { map.lastKey(), map.firstKey() };
    }
}