import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long result = 0;

        long[] distances = getArray(n - 1, bf);
        Costs costs = new Costs(getArray(n, bf));

        long cost = costs.getNextCost();

        for (int i = 0; i < n - 1; i++) {

            long distance = distances[i];
            long nextCost = costs.getNextCost();

            if (cost > nextCost) {
                result += distance * cost;
                cost = nextCost;
                continue;
            }

            result += distance * cost;

        }

        System.out.println(result);
    }

    private static long[] getArray(int size, BufferedReader bf) throws IOException {
        long[] arr = new long[size];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < size; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        return arr;
    }

    static class Costs {
        private final long[] costs;
        private int index;

        public Costs(long[] costs) {
            this.costs = costs;
        }

        public long getNextCost() {
            return costs[index++];
        }
    }
}