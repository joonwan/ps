import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(bf.readLine());

        for (int i = 0; i < tc; i++) {
            sol();
        }
    }

    private static void sol() throws IOException {
        int count = Integer.parseInt(bf.readLine());
        int result = 1;
        List<Person> persons = new ArrayList<>();

        for(int i = 0 ; i < count; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int score1 = Integer.parseInt(st.nextToken());
            int score2 = Integer.parseInt(st.nextToken());
            persons.add(new Person(score1, score2));
        }

        persons.sort((p1, p2) -> p1.score1 - p2.score1);

        int beforeTopRank = persons.get(0).score2;

        for(int i = 1; i < count; i++) {
            Person now = persons.get(i);
            if (beforeTopRank > now.score2) {
                result++;
                beforeTopRank = now.score2;
            }
        }

        System.out.println(result);
    }

    static class Person {
        private int score1;
        private int score2;

        public Person(int score1, int score2) {
            this.score1 = score1;
            this.score2 = score2;
        }

    }
}