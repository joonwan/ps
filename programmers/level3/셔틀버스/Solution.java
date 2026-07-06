import java.util.*;

class Solution {

    private PriorityQueue<Time> heap;

    public String solution(int n, int t, int m, String[] timetable) {

        Time answer = null;

        heap = new PriorityQueue<>((t1, t2) -> {
            if (t1.hour == t2.hour) {
                return t1.min - t2.min;
            }

            return t1.hour - t2.hour;
        });

        for (String tt : timetable) {
            StringTokenizer st = new StringTokenizer(tt, ":");
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());

            heap.offer(new Time(hour, min));
        }

        Time now = new Time(9, 0);
        int turn = 1;
        int count = 0;

        while (true) {

            // System.out.println("now = " + now);
            // System.out.println("count = " + count);
            // System.out.println("남은 인원 = " + heap.size());
            // System.out.println("최초 대기 = " + heap.peek());

            Time last = null;

            while (!heap.isEmpty() && count < m && now.biggerThanOrEquals(heap.peek())) {
                last = heap.poll();
                // System.out.println("탑승");
                count++;
            }

            if (turn == n) {
                if (last != null && count == m) {
                    answer = last;
                    answer.minusOneMinute();
                    break;
                } else {
                    answer = now;
                    break;
                }
            }

            now.plusMinute(t);
            turn++;
            count = 0;
        }

        return answer.toString();
    }

    static class Time {
        int hour, min;

        public Time(int hour, int min) {
            this.hour = hour;
            this.min = min;
        }

        void plusMinute(int min) {
            this.min += min;
            if (this.min >= 60) {
                this.min %= 60;
                plusHour(min / 60);
            }
        }

        void plusHour(int hour) {
            this.hour++;
            if (this.hour >= 24) {
                this.hour %= 24;
            }
        }

        void minusOneMinute() {
            if (this.min == 0) {
                hour = hour > 0 ? hour - 1 : 23;
                min = 59;
            } else {
                this.min--;
            }
        }

        boolean biggerThanOrEquals(Time other) {
            if (this.hour > other.hour)
                return true;
            if (this.hour == other.hour && this.min >= other.min)
                return true;
            return false;
        }

        public String toString() {
            String hs = hour >= 10 ? "" + hour : "0" + hour;
            String ms = min >= 10 ? "" + min : "0" + min;

            return hs + ":" + ms;
        }
    }
}