import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int a, b, c;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        while (true) {
            init();
            if (a + b + c == 0) {
                break;
            }
            sol();
        }
        
    }

    private static void sol() {
        
        ArrayList<Integer> list = new ArrayList<>();

        list.add(a);
        list.add(b);
        list.add(c);

        list.sort((n1, n2) -> n2 - n1);

        if (list.get(0) >= (list.get(1) + list.get(2))) {
            System.out.println("Invalid");
            return ;
        }

        HashSet<Integer> set = new HashSet<>(list);
        int size = set.size();

        if (size == 1) {
            System.out.println("Equilateral");
            return ;
        } 

        if (size == 2) {
            System.out.println("Isosceles");
            return;
        }

        System.out.println("Scalene");
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }
}
