package Vanilla.openai;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task82 {

    public static String hashPasswordWithSalt(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] hashedPassword = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedPassword) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(hashPasswordWithSalt("password123", "salt1")); // Test case 1
        System.out.println(hashPasswordWithSalt("helloWorld", "salt2"));  // Test case 2
        System.out.println(hashPasswordWithSalt("javaCode", "salt3"));    // Test case 3
        System.out.println(hashPasswordWithSalt("securePassword", "salt4")); // Test case 4
        System.out.println(hashPasswordWithSalt("hashThis", "salt5"));    // Test case 5
    }
}