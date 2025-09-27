package Vanilla.gpt4o;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task84 {
    public static String generateSessionId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sessionId = new StringBuilder();
        Random random = new Random();
        Set<String> uniqueIds = new HashSet<>();

        while (sessionId.length() < 16) { // 16-character length session ID
            int index = random.nextInt(characters.length());
            sessionId.append(characters.charAt(index));
        }

        String result = sessionId.toString();
        // Ensure the session ID is unique
        while (uniqueIds.contains(result)) {
            sessionId.setLength(0); // Clear the StringBuilder
            while (sessionId.length() < 16) {
                int index = random.nextInt(characters.length());
                sessionId.append(characters.charAt(index));
            }
            result = sessionId.toString();
        }

        uniqueIds.add(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateSessionId());
        System.out.println(generateSessionId());
        System.out.println(generateSessionId());
        System.out.println(generateSessionId());
        System.out.println(generateSessionId());
    }
}