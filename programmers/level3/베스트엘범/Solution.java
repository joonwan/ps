import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> totalInfoMap = new HashMap<>();
        HashMap<String, ArrayList<Node>> genreInfoMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            Node node = new Node(i, play);
            if (totalInfoMap.containsKey(genre)) {
                totalInfoMap.put(genre, totalInfoMap.get(genre) + play);
            } else {
                totalInfoMap.put(genre, play);
            }

            if (!genreInfoMap.containsKey(genre)) {
                ArrayList<Node> nodes = new ArrayList<>();
                nodes.add(node);
                genreInfoMap.put(genre, nodes);
            } else {
                genreInfoMap.get(genre).add(node);
            }
        }

        ArrayList<TotalInfo> totalInfoList = new ArrayList<>();
        for (String genre : totalInfoMap.keySet()) {
            totalInfoList.add(new TotalInfo(genre, totalInfoMap.get(genre)));
        }

        totalInfoList.sort((i1, i2) -> i2.play - i1.play);

        ArrayList<Integer> resultList = new ArrayList<>();
        for (String genre : genreInfoMap.keySet()) {
            genreInfoMap.get(genre).sort((n1, n2) -> n2.plays - n1.plays);
        }

        for (TotalInfo totalInfo : totalInfoList) {
            ArrayList<Node> nodes = genreInfoMap.get(totalInfo.genre);
            for (int i = 0; i < nodes.size() && i < 2; i++) {
                resultList.add(nodes.get(i).idx);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    static class Node {
        int idx;
        int plays;

        public Node(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }
    }

    static class TotalInfo {
        String genre;
        int play;

        public TotalInfo(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }
    }
}