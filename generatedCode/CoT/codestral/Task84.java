package CoT.codestral;
import java.util.UUID;

public class Task84 {
    public static String generateSessionId() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(generateSessionId());
        System.out.println(generateSessionId());
        System.out.println(generateSessionId());
        System.out.println(generateSessionId());
        System.out.println(generateSessionId());
    }
}