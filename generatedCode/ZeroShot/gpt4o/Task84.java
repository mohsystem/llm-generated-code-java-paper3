package ZeroShot.openai;
import java.security.SecureRandom;

public class Task84 {
    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int SESSION_ID_LENGTH = 20;
    private static final SecureRandom random = new SecureRandom();

    public static String generateSessionID() {
        StringBuilder sessionId = new StringBuilder(SESSION_ID_LENGTH);
        for (int i = 0; i < SESSION_ID_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sessionId.append(CHARACTERS.charAt(index));
        }
        return sessionId.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Session ID " + (i + 1) + ": " + generateSessionID());
        }
    }
}