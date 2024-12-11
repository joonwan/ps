import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int res = 0;

        List<Integer> coins = getCoins(bf, n);

        List<Integer> minCoins = coins.stream()
                .filter(c -> c <= k)
                .sorted((c1, c2) -> c2 - c1)
                .collect(Collectors.toList());

        int target = k;
        for(Integer coin : minCoins) {
            res += target / coin;
            target = target % coin;
        }

        System.out.println(res);
    }

    private static List<Integer> getCoins(BufferedReader bf, int n) throws IOException {

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(bf.readLine()));
        }

        return coins;
    }
}