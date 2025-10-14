package ZeroShot.openai;
import java.security.SecureRandom;

public class Task128 {

    public static String generateSecureToken(int length) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder token = new StringBuilder(length);
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        for (int i = 0; i < length; i++) {
            token.append(characters.charAt(secureRandom.nextInt(characters.length())));
        }
        return token.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(generateSecureToken(10)); // Test case 1
        System.out.println(generateSecureToken(15)); // Test case 2
        System.out.println(generateSecureToken(20)); // Test case 3
        System.out.println(generateSecureToken(25)); // Test case 4
        System.out.println(generateSecureToken(30)); // Test case 5
    }
}