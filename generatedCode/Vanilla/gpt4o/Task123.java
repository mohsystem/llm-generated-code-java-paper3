package Vanilla.openai;
public class Task123 {
    private HashMap<String, String> sessions = new HashMap<>();

    public void addSession(String userId, String sessionId) {
        sessions.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessions.get(userId);
    }

    public void removeSession(String userId) {
        sessions.remove(userId);
    }

    public static void main(String[] args) {
        Task123 sessionManager = new Task123();
        sessionManager.addSession("user1", "session1");
        sessionManager.addSession("user2", "session2");
        System.out.println(sessionManager.getSession("user1")); // session1
        sessionManager.removeSession("user1");
        System.out.println(sessionManager.getSession("user1")); // null
        sessionManager.addSession("user3", "session3");
        System.out.println(sessionManager.getSession("user3")); // session3
    }
}