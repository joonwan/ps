import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int res = 0;

        List<Human> humans = getHumans(bf, n);
        humans.sort((h1, h2) -> {
            return h1.time - h2.time;
        });

        wailAllHumans(humans);
        for(Human human : humans) {
            res += human.time;
        }
        System.out.println(res);
    }

    private static List<Human> getHumans(BufferedReader bf, int n) throws IOException {
        String data = bf.readLine();
        StringTokenizer st = new StringTokenizer(data);

        List<Human> humans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int time = Integer.parseInt(st.nextToken());
            humans.add(new Human(i, time));
        }

        return humans;
    }

    private static void wailAllHumans(List<Human> humans) {
        int waitTime = 0;

        for(int i = 1 ; i < humans.size() ; i ++) {
            Human nowHuman = humans.get(i);
            Human beforeHuman = humans.get(i - 1);

            nowHuman.wait(beforeHuman.time);
        }
    }

    static class Human {
        int idx;
        int time;

        public Human(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        public void wait(int time) {
            this.time += time;
        }
    }
}