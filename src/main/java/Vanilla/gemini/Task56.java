package Vanilla.gemini;
import java.util.UUID;

class Task56 {
    public static String generateToken() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(generateToken());
        System.out.println(generateToken());
        System.out.println(generateToken());
        System.out.println(generateToken());
        System.out.println(generateToken());
    }
}