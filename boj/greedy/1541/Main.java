import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        String input = bf.readLine();

        List<String> positvieNumberString = splitByMinus(input);
        List<Integer> numbers = toIntegerList(positvieNumberString);
        res = numbers.get(0);

        for(int i = 1; i < numbers.size(); i++) {
            res -= numbers.get(i);
        }

        System.out.println(res);

    }

    private static List<String> splitByMinus(String input) {
        List<String> result = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(input, "-");
        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }
        return result;
    }

    private static List<Integer> toIntegerList(List<String> positvieNumberString) {
        List<Integer> result = new ArrayList<>();

        for (String s : positvieNumberString) {
            int number = 0;
            if (s.contains("+")) {
                StringTokenizer st = new StringTokenizer(s, "+");
                while (st.hasMoreTokens()) {
                    number += Integer.parseInt(st.nextToken());
                }
            } else {
                number = Integer.parseInt(s);
            }

            result.add(number);
        }

        return result;
    }
}