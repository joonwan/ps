import java.util.*;

class Solution {
    public int[] solution(int target) {

        List<int[]> shots = makeShots();
        int[][] dp = new int[target + 1][2];
        int INF = Integer.MAX_VALUE;

        for (int score = 1; score <= target; score++) {
            dp[score][0] = INF;
            dp[score][1] = -1;
        }

        dp[0][0] = 0;
        dp[0][1] = 0;

        for (int score = 1; score <= target; score++) {
            for (int[] shot : shots) {
                int shotScore = shot[0];
                int singleOrBull = shot[1];

                if (shotScore > score)
                    continue;

                int previousScore = score - shotScore;
                int candidateDart = dp[previousScore][0] + 1;
                int candidateSingleOrBull = dp[previousScore][1] + singleOrBull;

                if (candidateDart < dp[score][0]) {
                    dp[score][0] = candidateDart;
                    dp[score][1] = candidateSingleOrBull;
                } else if (candidateDart == dp[score][0] && candidateSingleOrBull > dp[score][1]) {
                    dp[score][1] = candidateSingleOrBull;
                }
            }
        }
        return dp[target];
    }

    private List<int[]> makeShots() {
        List<int[]> shots = new ArrayList<>();

        for (int number = 1; number <= 20; number++) {

            // single
            shots.add(new int[] { number, 1 });

            // double
            shots.add(new int[] { number * 2, 0 });

            // triple
            shots.add(new int[] { number * 3, 0 });
        }

        shots.add(new int[] { 50, 1 });

        return shots;
    }
}

/**
 * 
 * 점수: 1 - 20
 * 싱글, 더블, 트리플 칸 존재
 * 불 , 아우터 -> 50 점 고정
 * 
 * 최소한의 다트로 0점 만들기
 * 방법이 여러가지라면 싱글 또는 불을 최대한 많이 던지는 방법을 고민 해야함.
 * 
 * target <= 100,000
 * 
 * 1. 최소한 던짐
 * 2. 불, 싱글 많이 던지는 방향
 * 
 * 반환 결과 : [다트수, (싱글 + 불) 횟수]
 * 
 * 21
 * 
 * 0 -> 0
 * 1 -> 1 하나
 * 2 -> 2 싱글, 1 더블
 * 3 -> 3 싱글, 2싱글 + 1싱글,
 * 4 -> 4 싱글, 3싱글 + 1싱글, 2싱글 + 2싱글, 2 더블,
 * 
 * 
 * 현재 점수 = min(이전 점수 최소 수 + 1, )
 */