package Vanilla.llama31;
public class Task123 {
    public static class Session {
        String sessionId;
        String userId;
        long createTime;
        long lastAccessTime;

        public Session(String userId) {
            this.userId = userId;
            this.sessionId = java.util.UUID.randomUUID().toString();
            this.createTime = System.currentTimeMillis();
            this.lastAccessTime = createTime;
        }

        public void updateLastAccessTime() {
            this.lastAccessTime = System.currentTimeMillis();
        }

        public boolean isExpired(long timeout) {
            return System.currentTimeMillis() - lastAccessTime > timeout;
        }
    }

    public static void main(String[] args) {
        // Test cases
        Session session1 = new Session("user1");
        System.out.println("Session ID: " + session1.sessionId);
        session1.updateLastAccessTime();
        System.out.println("Is Expired? " + session1.isExpired(10000)); // 10 seconds

        Session session2 = new Session("user2");
        System.out.println("Session ID: " + session2.sessionId);
        try {
            Thread.sleep(11000); // Sleep for 11 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Is Expired? " + session2.isExpired(10000)); // 10 seconds

        Session session3 = new Session("user3");
        System.out.println("Session ID: " + session3.sessionId);
        session3.updateLastAccessTime();
        System.out.println("Is Expired? " + session3.isExpired(10000)); // 10 seconds

        Session session4 = new Session("user4");
        System.out.println("Session ID: " + session4.sessionId);
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Is Expired? " + session4.isExpired(10000)); // 10 seconds

        Session session5 = new Session("user5");
        System.out.println("Session ID: " + session5.sessionId);
        try {
            Thread.sleep(15000); // Sleep for 15 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Is Expired? " + session5.isExpired(10000)); // 10 seconds
    }
}