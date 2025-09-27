package Vanilla.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Task82 {
    public static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String passwordWithSalt = password + salt;
            byte[] hashedBytes = md.digest(passwordWithSalt.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(hashPassword("password123", "salt123")); 
        System.out.println(hashPassword("abc123", "randomsalt"));
        System.out.println(hashPassword("securepass", "pepper"));
        System.out.println(hashPassword("test1234", "sodium"));
        System.out.println(hashPassword("mypassword", "sugar"));
    }
}
