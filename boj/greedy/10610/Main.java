import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();

        if (!isMakeable(input)) {
            System.out.println(-1);
            return;
        }

        List<Integer> numbers = getEachNumbers(input);
        numbers.sort((n1, n2) -> n2 - n1);

        StringBuilder result = new StringBuilder();
        for (Integer number : numbers) {
            result.append(number);
        }

        System.out.println(result);
    }

    private static boolean isMakeable(String data) {
        if (!data.contains("0")) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < data.length(); i++) {
            sum += Integer.parseInt(data.charAt(i) + "");
        }

        if (sum % 3 != 0) {
            return false;
        }

        return true;
    }

    private static List<Integer> getEachNumbers(String data) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            numbers.add(Integer.parseInt(data.charAt(i) + ""));
        }

        return numbers;
    }
}