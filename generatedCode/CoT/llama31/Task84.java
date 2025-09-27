package CoT.llama31;
import java.util.UUID;

public class Task84 {
    public static String generateSessionID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Session ID: " + generateSessionID());
        }
    }
}