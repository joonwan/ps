import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        int[] cards = getArray(n);

        HashMap<Integer, Integer> countMap = toCountMap(cards);

        int m = Integer.parseInt(bf.readLine());
        int[] numbers = getArray(m);

        for (int i = 0; i < m; i++) {
            int number = numbers[i];
            if (countMap.containsKey(number)) {
                sb.append(countMap.get(number)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static int[] getArray(int size) throws IOException {
        int[] arr = new int[size];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        return arr;
    }

    private static HashMap<Integer, Integer> toCountMap(int[] cards) {

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];
            if (countMap.containsKey(card)) {
                countMap.put(card, countMap.get(card) + 1);
            } else {
                countMap.put(card, 1);
            }
        }

        return countMap;
    }
}