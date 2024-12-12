import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            int res = 0;

            int money = Integer.parseInt(bf.readLine());
            Change change = new Change(money);

            change.calculate();
            List<Integer> changeCount = change.getChangeCount();
            printChangeCount(changeCount);
        }
    }

    private static void printChangeCount(List<Integer> changeCount) {
        StringBuilder sb = new StringBuilder();
        for (Integer count : changeCount) {
            sb.append(count).append(" ");
        }
        System.out.println(sb);

    }

    static class Change {

        int money;
        List<Integer> coins = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        public Change(int money) {
            this.money = money;
            this.coins.add(25);
            this.coins.add(10);
            this.coins.add(5);
            this.coins.add(1);
        }

        public void calculate() {
            for (Integer coin : coins) {
                count.add(money / coin);
                money %= coin;
            }
        }

        public List<Integer> getChangeCount() {
            return count;
        }

    }
}