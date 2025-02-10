import java.util.StringTokenizer;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        Pos end = new Pos(video_len);
        Pos now = new Pos(pos);
        Pos os = new Pos(op_start);
        Pos oe = new Pos(op_end);

        VideoPlayer vp = new VideoPlayer(now, os, oe, end);
        vp.handleCommands(commands);

        return vp.getNow();
    }

    static class VideoPlayer {

        Pos now;
        Pos op_start;
        Pos op_end;
        Pos end;

        public VideoPlayer(Pos now, Pos op_start, Pos op_end, Pos end) {
            this.now = now;
            this.op_start = op_start;
            this.op_end = op_end;
            this.end = end;

            checkOpening();

        }

        public String getNow() {
            return String.format("%02d", now.min) + ":" + String.format("%02d",now.sec);
        }

        public void handleCommands(String[] commands) {

            for (String command : commands) {
                handleCommand(command);
                checkOpening();
                // System.out.println(getNow());
            }
        }

        private void handleCommand(String command) {
            if (command.equals("next")) {
                now.next(end);
                return ;
            }
            now.prev();
        }

        private void checkOpening() {
            if (now.compare(op_start) >= 0 && now.compare(op_end) <= 0) {
                now.change(op_end);
            }
        }

    }

    static class Pos {
        int min;
        int sec;

        public Pos(String data) {
            StringTokenizer st = new StringTokenizer(data, ":");
            int min = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            this.min = min;
            this.sec = sec;
        }


        public int compare(Pos other) {
            if (this.min != other.min) {
                return this.min - other.min;
            }

            return this.sec - other.sec;
        }

        public void change(Pos other) {
            this.min = other.min;
            this.sec = other.sec;
        }

        public void prev() {
            if (this.min == 0 && this.sec <= 10) {
                this.sec = 0;
                return ;
            }

            this.sec -= 10;
            if (this.sec < 0) {
                this.min--;
                this.sec += 60;
            }
        }

        public void next(Pos end) {
            this.sec += 10;
            if (sec >= 60) {
                this.min += 1;
                this.sec -= 60;
            }

            if (this.compare(end) > 0) {
                this.change(end);
            }
        }
    }
}

/**
 동영상 재생기 기능
 - 10초 전으로 이동 -> prev 입력 (10 초 미만일 경우 처음 위치로 이동 (처음 위치 : 0분 0초))
 - 10초 후로 이동  -> next 입력 (남은 동영상 10초 미만일 경우 마지막 위치 (마지막 위치 : 동영상 길이와 동일))
 - 오프닝 건너뛰기 -> 현재 위치가 오프닝 구간 (op_start <= now <= op_end) 인 경우 자동으로 오프닝이 끝ㄴㅏ는 위치로이동

 변수 정리

 video_len : 동영상 길이
 pos : 기능이 수행되기 직전의 재생위치
 op_start : 오프닝 시작 시간
 op+end : 오프닝 끝 시간
 commands : 사용자 입력들

 반환값
 사용자 입력이 모두 끝난 후 동영상 위치를 mm:ss 형식으로 리턴
 */