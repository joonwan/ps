import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};

        ChatRoom chatRoom = new ChatRoom();
        chatRoom.handleRecord(record);

        return  chatRoom.getLogs();

    }

    static class ChatRoom {
        ArrayDeque<Log> logs = new ArrayDeque<>();
        HashMap<String, User> users = new HashMap<>();

        public void handleRecord(String[] record) {
            for (String data : record) {
                handleData(data);
            }
        }

        public String[] getLogs() {
            String[] result = new String[logs.size()];
            int index = 0;

            while (!logs.isEmpty()) {
                Log log = logs.poll();
                result[index++] = log.toString();
            }
            return result;
        }

        private void handleData(String data) {
            StringTokenizer st = new StringTokenizer(data);

            String command = st.nextToken();
            String uid = st.nextToken();

            if (command.equals("Enter")) {
                String nickName = st.nextToken();
                enter(uid, nickName);
            }

            if (command.equals("Leave")) {
                leave(uid);
            }

            if (command.equals("Change")) {
                String nickName = st.nextToken();
                change(uid, nickName);
            }
        }

        private void enter(String uid, String nickName) {
            User findUser = users.get(uid);

            if (findUser == null) {
                findUser = new User(nickName);
                users.put(uid, findUser);
            }

            if (!findUser.nickName.equals(nickName)) {
                findUser.changeNickName(nickName);
            }

            logs.add(new Log(findUser, Type.ENTER));
        }

        private void leave(String uid) {
            User findUser = users.get(uid);
            logs.add(new Log(findUser, Type.LEAVE));
        }

        private void change(String uid, String nickName) {
            User findUser = users.get(uid);
            findUser.changeNickName(nickName);
        }

        static class User {
            String nickName;

            public User(String nickName) {
                this.nickName = nickName;
            }

            public void changeNickName(String nickName) {
                this.nickName = nickName;
            }
        }

        static class Log {
            User user;
            Type type;

            public Log(User user, Type type) {
                this.user = user;
                this.type = type;
            }

            @Override
            public String toString() {
                if (type == Type.ENTER) {
                    return user.nickName + "님이 들어왔습니다.";
                }
                return user.nickName + "님이 나갔습니다.";
            }

        }
        static enum Type {
            ENTER, LEAVE;
        }
    }
}