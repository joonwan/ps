import java.util.*;

class Solution {

    String[] user_id, banned_id;
    HashSet<Integer> result;

    public int solution(String[] user_id, String[] banned_id) {

        this.user_id = user_id;
        this.banned_id = banned_id;

        result = new HashSet<>();
        dfs(0, 0);

        return result.size();
    }

    private void dfs(int b_idx, int mask) {
        if (b_idx == banned_id.length) {
            result.add(mask);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if ((mask & (1 << i)) != 0)
                continue;
            if (!matches(banned_id[b_idx], user_id[i]))
                continue;
            dfs(b_idx + 1, mask | (1 << i));
        }
    }

    private boolean matches(String b_id, String u_id) {
        if (b_id.length() != u_id.length())
            return false;

        for (int i = 0; i < b_id.length(); i++) {
            if (b_id.charAt(i) == '*')
                continue;
            if (b_id.charAt(i) != u_id.charAt(i))
                return false;
        }

        return true;
    }
}