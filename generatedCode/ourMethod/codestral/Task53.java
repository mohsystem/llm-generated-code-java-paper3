package ourMethod.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task53 {
    private Map<String, SessionData> sessions;

    public Task53() {
        sessions = new HashMap<>();
    }

    public void createSession(String userId, SessionData data) {
        sessions.put(userId, data);
    }

    public SessionData getSession(String userId) {
        return sessions.get(userId);
    }

    public void endSession(String userId) {
        sessions.remove(userId);
    }

    public static void main(String[] args) {
        Task53 sessionManager = new Task53();

        sessionManager.createSession("1", new SessionData("Data for user 1"));
        sessionManager.createSession("2", new SessionData("Data for user 2"));

        System.out.println(sessionManager.getSession("1").getData());
        System.out.println(sessionManager.getSession("2").getData());

        sessionManager.endSession("1");
        System.out.println(sessionManager.getSession("1")); // Should print null
    }
}

class SessionData {
    private String data;

    public SessionData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}