import java.io.*;
import java.util.ArrayList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        char[] arr = br.readLine().toCharArray();

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0 ; i <arr.length; i++) {
            result.add(arr[i] + "");
        }

        result.sort((s1, s2) -> s2.compareTo(s1));

        for (int i = 0; i< result.size(); i++) {
            bw.write(result.get(i));
        }

        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}