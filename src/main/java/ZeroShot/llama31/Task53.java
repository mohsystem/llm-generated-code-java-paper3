package ZeroShot.llama31;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Task53 {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        String sessionId1 = sessionManager.createSession("User1");
        String sessionId2 = sessionManager.createSession("User2");

        sessionManager.updateSession(sessionId1, "key", "value");
        System.out.println(sessionManager.getSessionData(sessionId1));

        sessionManager.expireSession(sessionId2);
        System.out.println(sessionManager.getSessionData(sessionId2));
    }
}

class SessionManager {
    private Map<String, Session> sessions = new HashMap<>();
    private long expirationTime = TimeUnit.MINUTES.toMillis(15);

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, new Session(username, System.currentTimeMillis() + expirationTime));
        return sessionId;
    }

    public void updateSession(String sessionId, String key, String value) {
        if (sessions.containsKey(sessionId)) {
            sessions.get(sessionId).setData(key, value);
        }
    }

    public String getSessionData(String sessionId) {
        if (sessions.containsKey(sessionId) && !isExpired(sessionId)) {
            return sessions.get(sessionId).getData();
        }
        return "Session expired or does not exist";
    }

    public void expireSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }

    private boolean isExpired(String sessionId) {
        return System.currentTimeMillis() > sessions.get(sessionId).getExpirationTime();
    }

    class Session {
        private String username;
        private long expirationTime;
        private Map<String, String> data = new HashMap<>();

        public Session(String username, long expirationTime) {
            this.username = username;
            this.expirationTime = expirationTime;
        }

        public void setData(String key, String value) {
            data.put(key, value);
        }

        public String getData() {
            return data.toString();
        }

        public long getExpirationTime() {
            return expirationTime;
        }
    }
}