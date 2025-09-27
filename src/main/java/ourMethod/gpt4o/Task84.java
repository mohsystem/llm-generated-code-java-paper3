package ourMethod.gpt4o;
import java.security.SecureRandom;

public class Task84 {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int SESSION_ID_LENGTH = 16;

    public static String generateSessionID() {
        SecureRandom random = new SecureRandom();
        StringBuilder sessionId = new StringBuilder(SESSION_ID_LENGTH);
        
        for (int i = 0; i < SESSION_ID_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sessionId.append(CHARACTERS.charAt(index));
        }
        
        return sessionId.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Test Case " + (i + 1) + ": " + generateSessionID());
        }
    }
}