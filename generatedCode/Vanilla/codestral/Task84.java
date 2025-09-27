package Vanilla.codestral;
import java.util.UUID;

public class Task84 {
    public static String generateSessionID() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(generateSessionID());
        System.out.println(generateSessionID());
        System.out.println(generateSessionID());
        System.out.println(generateSessionID());
        System.out.println(generateSessionID());
    }
}