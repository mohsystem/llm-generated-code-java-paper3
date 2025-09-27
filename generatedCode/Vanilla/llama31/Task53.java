package Vanilla.llama31;
public class Task53 {
    public static class Session {
        String userId;
        String sessionId;
        long startTime;

        public Session(String userId, String sessionId) {
            this.userId = userId;
            this.sessionId = sessionId;
            this.startTime = System.currentTimeMillis();
        }

        public boolean isValid() {
            // Simple validation: session is valid for 30 minutes
            return System.currentTimeMillis() - startTime < 30 * 60 * 1000;
        }
    }

    public static void main(String[] args) {
        // Test cases
        Session session1 = new Session("user1", "session1");
        Session session2 = new Session("user2", "session2");

        System.out.println("Is session1 valid? " + session1.isValid());
        System.out.println("Is session2 valid? " + session2.isValid());

        try {
            Thread.sleep(31000); // Wait for more than 30 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Is session1 valid after 30 seconds? " + session1.isValid());
        System.out.println("Is session2 valid after 30 seconds? " + session2.isValid());
    }
}