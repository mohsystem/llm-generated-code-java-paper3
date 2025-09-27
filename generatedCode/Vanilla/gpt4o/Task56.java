package Vanilla.gpt4o;
import java.util.Random;

public class Task56 {
    public static String generateToken(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder token = new StringBuilder();
        Random rnd = new Random();
        while (token.length() < length) {
            int index = (int) (rnd.nextFloat() * characters.length());
            token.append(characters.charAt(index));
        }
        return token.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(generateToken(10)); // Test case 1
        System.out.println(generateToken(15)); // Test case 2
        System.out.println(generateToken(20)); // Test case 3
        System.out.println(generateToken(25)); // Test case 4
        System.out.println(generateToken(30)); // Test case 5
    }
}