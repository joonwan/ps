import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Job> jq = new PriorityQueue<>((j1, j2) -> j1.requestTime - j2.requestTime);
        PriorityQueue<Job> hq = new PriorityQueue<>((j1, j2) -> {
            if (j1.processingTime == j2.processingTime) {
                if (j1.requestTime == j2.requestTime) {
                    return j1.idx - j2.idx;
                }
                return j1.requestTime - j2.requestTime;
            }
            return j1.processingTime - j2.processingTime;
        });

        for (int i = 0; i < jobs.length; i++) {
            jq.offer(new Job(i, jobs[i][1], jobs[i][0]));
        }

        int time = 0;
        int count = 0;

        while (count < jobs.length) {
            while (!jq.isEmpty() && jq.peek().requestTime <= time)
                hq.offer(jq.poll());
            if (hq.isEmpty()) {
                time = jq.peek().requestTime;
                continue;
            }

            Job now = hq.poll();
            time += now.processingTime;
            answer += (time - now.requestTime);
            count++;
        }

        return answer / count;

    }

    static class Job {

        int idx;
        int processingTime;
        int requestTime;

        public Job(int idx, int processingTime, int requestTime) {
            this.idx = idx;
            this.processingTime = processingTime;
            this.requestTime = requestTime;
        }

    }
}