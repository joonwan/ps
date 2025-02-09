import java.util.ArrayDeque;

class Solution {
    public int solution(int n, int a, int b) {

        ArrayDeque<Integer> users = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            users.offer(i + 1);
        }

        Game game = new Game(users, a, b);
        return game.getRound();

    }

    static class Game {
        ArrayDeque<Integer> users;
        ArrayDeque<Integer> winners = new ArrayDeque<>();
        int targetA;
        int targetB;
        int round;

        public Game(ArrayDeque<Integer> users, int targetA, int targetB) {
            this.users = users;
            this.targetA = targetA;
            this.targetB = targetB;
        }

        public int getRound() {
            run();
            return round;
        }

        private void run() {
            boolean operate = true;

            while (operate) {
                round++;
                while (!users.isEmpty()) {
                    int user1 = users.poll();
                    int user2 = users.poll();

                    if (isAllTarget(user1, user2)) {
                        operate = false;
                        break;
                    }

                    if (user1 == targetA || user1 == targetB) {
                        winners.offer(user1);
                    } else if (user2 == targetA || user2 == targetB) {
                        winners.offer(user2);
                    } else {
                        winners.offer(user1);
                    }
                }

                users = new ArrayDeque<>(winners);
                winners.clear();
            }
        }


        private boolean isAllTarget(int a, int b) {
            if ((a == targetA || a == targetB) && (b == targetA || b == targetB)) {
                return true;
            }
            return false;
        }
    }
}