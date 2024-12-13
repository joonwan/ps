import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(bf.readLine());

        Change change = new Change(1000 - money);
        int changeCount = change.getChangeCount();

        System.out.println(changeCount);
    }

    static class Change {
        List<Integer> coins = List.of(500, 100, 50, 10, 5, 1);

        private int money;

        public Change(int money) {
            this.money = money;
        }

        public int getChangeCount() {
            int changeCount = 0;

            for(Integer coin : coins) {
                changeCount += money / coin;
                money %= coin;
            }

            return changeCount;
        }
    }
}