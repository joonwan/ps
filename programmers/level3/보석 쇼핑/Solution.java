import java.util.*;

class Solution {

    int rs;
    int re;

    public int[] solution(String[] gems) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (String gem : gems)
            set.add(gem);
        rs = 0;
        re = gems.length - 1;

        int s = 0;
        int e = 0;

        while (e < gems.length) {
            map.put(gems[e], map.getOrDefault(gems[e], 0) + 1);

            while (map.size() == set.size()) {
                update(s, e);
                map.put(gems[s], map.get(gems[s]) - 1);
                if (map.get(gems[s]) == 0)
                    map.remove(gems[s]);
                s++;
            }

            e++;
        }

        return new int[] { rs + 1, re + 1 };
    }

    private void update(int s, int e) {
        if ((re - rs) > (e - s)) {
            rs = s;
            re = e;
        }
    }
}
