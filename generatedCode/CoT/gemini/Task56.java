package CoT.gemini;
import java.security.SecureRandom;
import java.util.Base64;

public class Task56 {

    public static String generateToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[24]; // Adjust token length as needed
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    public static void main(String[] args) {
        System.out.println(generateToken());
        System.out.println(generateToken());
        System.out.println(generateToken());
        System.out.println(generateToken());
        System.out.println(generateToken());
    }
}