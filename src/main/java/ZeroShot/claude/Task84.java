package ZeroShot.claude;

import java.util.UUID;

public class Task84 {
    public static String generateSessionId() {
        return UUID.randomUUID().toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        for(int i=0; i<5; i++) {
            System.out.println("Session ID " + (i+1) + ": " + generateSessionId());
        }
    }
}
