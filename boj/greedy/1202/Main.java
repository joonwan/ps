import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long totalPrice = 0;

        List<Gem> gems = getGems(n);
        List<Bag> bags = getBags(k);

        PriorityQueue<Gem> pq = new PriorityQueue<>((g1, g2) -> g2.price - g1.price);

        int gemIndex = 0;
        for (Bag bag : bags) {
            while (gemIndex < n) {
                Gem gem = gems.get(gemIndex);
                if (bag.canPut(gem)) {
                    pq.offer(gem);
                    gemIndex++;
                } else {
                    break;
                }
            }

            if (!pq.isEmpty()) {
                totalPrice += pq.poll().price;
            }
        }

        System.out.println(totalPrice);
    }

    private static List<Gem> getGems(int n) throws IOException {
        List<Gem> gems = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            gems.add(new Gem(weight, height));
        }

        gems.sort((g1, g2) -> {
            if (g1.weight == g2.weight) {
                return g2.price - g1.price;
            }
            return g1.weight - g2.weight;
        });

        return gems;
    }

    private static List<Bag> getBags(int k) throws IOException {
        List<Bag> bags = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            bags.add(new Bag(Integer.parseInt(bf.readLine())));
        }

        bags.sort((b1, b2) -> b1.maxWeight - b2.maxWeight);

        return bags;
    }

    static class Gem {
        private int weight;
        private int price;

        public Gem(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

    }

    static class Bag {
        private int maxWeight;

        public Bag(int maxWeight) {
            this.maxWeight = maxWeight;
        }

        public boolean canPut(Gem gem) {
            return maxWeight >= gem.weight;
        }

    }
}