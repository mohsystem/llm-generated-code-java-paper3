package CoT.gpt4o;
import java.security.SecureRandom;
import java.math.BigInteger;

public class Task84 {

    private static SecureRandom random = new SecureRandom();

    public static String generateSessionId() {
        return new BigInteger(130, random).toString(32);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Session ID " + (i+1) + ": " + generateSessionId());
        }
    }
}