package ZeroShot.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task82 {
    public static String hashPassword(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
    
    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static void main(String[] args) {
        // Test cases
        String[] passwords = {
            "password123",
            "SecurePass!@#",
            "TestPass987",
            "ComplexP@ssw0rd",
            "SimpleP@ss"
        };

        for (String password : passwords) {
            byte[] salt = generateSalt();
            String hashedPassword = hashPassword(password, salt);
            System.out.println("Password: " + password);
            System.out.println("Salt (Base64): " + Base64.getEncoder().encodeToString(salt));
            System.out.println("Hashed Password: " + hashedPassword);
            System.out.println();
        }
    }
}
