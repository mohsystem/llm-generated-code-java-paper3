package ourMethodv2.gpt4o;
import java.util.Random;

public class Task85 {
    public static String generateRandomString(int length) {
        if (length <= 0) return "";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(5));
        System.out.println(generateRandomString(15));
        System.out.println(generateRandomString(8));
        System.out.println(generateRandomString(0));
    }
}