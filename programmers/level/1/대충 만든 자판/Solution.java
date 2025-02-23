import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {

        int idx = 0;
        ArrayList<HashMap<String, Integer>> keyMaps = getKeyMaps(keymap);
        int[] answer = new int[targets.length];

        for (String target : targets) {
            int result = 0;

            for (int i = 0 ; i < target.length(); i++) {
                String key = target.charAt(i) + "";
                int tmp = 2147483647;

                for (HashMap<String, Integer> map : keyMaps) {
                    if (map.containsKey(key)) {
                        tmp = Math.min(tmp, map.get(key));
                    }
                }
                if (tmp == 2147483647) {
                    result = -1;
                    break;
                } else {
                    result += tmp;
                }
            }
            answer[idx++] = result;
        }

        return answer;
    }

    private ArrayList<HashMap<String, Integer>> getKeyMaps(String[] keymap) {
        ArrayList<HashMap<String, Integer>> result = new ArrayList<>();

        for (String data : keymap) {
            char[] arr = data.toCharArray();
            HashMap<String, Integer> map = new HashMap<>();

            int idx = 0;
            for (int i= 0 ; i < arr.length; i++) {
                String key = arr[i] + "";

                if (!map.containsKey(key)) {
                    map.put(key, ++idx);
                } else {
                    idx++;
                }
            }

            result.add(map);
        }

        return result;
    }
}