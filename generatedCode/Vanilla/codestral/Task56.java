package Vanilla.codestral;
import java.util.UUID;

public class Task56 {
    public static String generateToken() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(generateToken());
    }
}