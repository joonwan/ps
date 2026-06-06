import java.util.*;

class Solution {
    public long solution(int n, int[] works) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);

        for (int work : works)
            maxHeap.offer(work);

        for (int i = n; i > 0; i--) {
            if (maxHeap.isEmpty())
                break;

            int maxVal = maxHeap.poll();

            if (maxVal == 1)
                continue;
            maxHeap.offer(maxVal - 1);
        }

        long answer = 0;

        while (!maxHeap.isEmpty()) {
            answer += (int) Math.pow(maxHeap.poll(), 2);
        }

        return answer;
    }
}