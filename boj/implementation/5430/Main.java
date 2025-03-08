import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;


public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int tc;
    private static ArrayDeque<String> numbers;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            sol();
        }
    }

    private static void sol() throws IOException {
        String commands = br.readLine();
        initNumbers();
        boolean operate = true;
        boolean reverse = false;

        for (int i = 0 ; i < commands.length(); i++) {
            char c = commands.charAt(i);

            if (c == 'R') {
                reverse = !reverse;
            } else if(c == 'D') {
                if (numbers.isEmpty()) {
                    operate = false;
                    break;
                }
                if (reverse) {
                    numbers.pollLast();
                } else {
                    numbers.poll();
                }
            }
        }
        if (!operate) {
            System.out.println("error");
            return ;
        }

        StringBuilder sb = new StringBuilder();

        while (!numbers.isEmpty()) {
            String s = null;
            if (reverse) {
                s = numbers.pollLast();
            } else {
                 s = numbers.poll();
            }
            if (numbers.isEmpty()) {
                sb.append(s);
            } else {
                sb.append(s).append(",");
            }
        }

        System.out.println("[" + sb + "]");
    }

    private static void initNumbers() throws IOException {
        numbers = new ArrayDeque<>();
        int size = Integer.parseInt(br.readLine());
        String data = br.readLine();
        StringTokenizer st = new StringTokenizer(data.substring(1, data.length() - 1), ",");

        for (int i = 0 ; i < size; i++) {
            numbers.offer(st.nextToken());
        }
    }

}