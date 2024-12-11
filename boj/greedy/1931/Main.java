import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int res = 1;

        List<Reservation> reservations = getReservations(bf, n);
        reservations.sort((r1, r2) -> {
            if (r1.endTime == r2.endTime) {
                return r1.startTime - r2.startTime;
            } else {
                return r1.endTime - r2.endTime;
            }
        });

        int endTime = reservations.get(0).endTime;

        for (int i = 1; i < reservations.size(); i++) {
            Reservation nextReservation = reservations.get(i);
            if (endTime <= nextReservation.startTime) {
                endTime = nextReservation.endTime;
                res++;
            }
        }

        System.out.println(res);
    }

    private static List<Reservation> getReservations(BufferedReader bf, int n) throws IOException {

        List<Reservation> reservations = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            reservations.add(new Reservation(startTime, endTime));
        }

        return reservations;
    }

    static class Reservation {
        int startTime;
        int endTime;

        public Reservation(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}