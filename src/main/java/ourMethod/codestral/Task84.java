package ourMethod.codestral;
import java.util.UUID;

public class Task84 {
    public static String generateSessionId() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(generateSessionId());
        }
    }
}