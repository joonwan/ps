import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        CircleQue circleQue = new CircleQue(n, k);

        StringBuilder sb = new StringBuilder();

        ArrayList<String> result = new ArrayList<>();
        while (circleQue.size() > 0) {
            result.add(circleQue.run());
        }

        sb.append("<").append(String.join(", ", result)).append(">");

        System.out.println(sb);

    }

    static class CircleQue {

        int size;
        int index;
        int k;
        ArrayList<Integer> humans = new ArrayList<>();

        public CircleQue(int size, int k) {
            this.size = size;
            this.k = k;

            for (int i = 0; i < size; i++) {
                humans.add(i + 1);
            }

        }

        public String run() {

            int nextIndex = (index + k - 1) % size;
            int removedNumber = humans.remove(nextIndex);

            size--;
            index = nextIndex;
            return removedNumber + "";
        }

        public int size() {
            return size;
        }

    }
}