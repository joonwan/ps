import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int res = 0;

        List<Integer> listA = getList(bf, n);
        List<Integer> listB = getList(bf, n);

        listA.sort((n1, n2) -> {return n1 - n2 ;});
        listB.sort((n1, n2) -> {return n2 - n1 ;});

        for (int i = 0 ; i < n; i++) {
            res += listA.get(i) * listB.get(i);
        }

        System.out.println(res);
    }

    private static List<Integer> getList(BufferedReader bf, int n) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        String data = bf.readLine();
        StringTokenizer st = new StringTokenizer(data);

        for(int i = 0 ; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        return numbers;
    }
}