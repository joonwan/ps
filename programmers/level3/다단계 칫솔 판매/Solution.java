import java.util.*;

class Solution {

    private ArrayList<ArrayList<Integer>> graph;
    private HashMap<String, Integer> indexMap;
    private int[] answer;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];

        init(enroll, referral);

        for (int i = 0; i < seller.length; i++) {
            int amt = amount[i] * 100;
            int now = indexMap.get(seller[i]);

            while (true) {
                int nextProfit = amt / 10;
                answer[now] += (amt - nextProfit);
                if (graph.get(now).isEmpty())
                    break;

                now = graph.get(now).get(0);
                amt = nextProfit;
            }
        }
        return answer;
    }

    private void init(String[] enroll, String[] referral) {
        // init index;
        indexMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++)
            indexMap.put(enroll[i], i);

        // init graph;
        graph = new ArrayList<>();
        for (int i = 0; i < enroll.length; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-"))
                continue;
            int ref = indexMap.get(referral[i]);
            int enr = indexMap.get(enroll[i]);

            graph.get(enr).add(ref);
        }

    }
}