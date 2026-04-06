import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {1, 1, 0};
    private static int[] dy = {0, 1, 1};
    private static StringTokenizer st;
    private static int n, m, w, h;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        init();
        System.out.println((int) (Math.ceil((double) h / n) * Math.ceil((double) w / m)));
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken()) + 1;
        m = Integer.parseInt(st.nextToken()) + 1;

    }   
}
