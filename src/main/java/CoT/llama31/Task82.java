package CoT.llama31;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class Task82 {
    public static String hashPasswordWithSalt(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String saltedPassword = password + salt;
            byte[] hashBytes = md.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        String password = "farm1990M0O";
        String salt = "f1nd1ngn3m0";
        System.out.println("Hash of password with salt: " + hashPasswordWithSalt(password, salt));

        // Test cases
        System.out.println("Hash of 'password123' with 'salt123': " + hashPasswordWithSalt("password123", "salt123"));
        System.out.println("Hash of 'testpassword' with 'testsalt': " + hashPasswordWithSalt("testpassword", "testsalt"));
        System.out.println("Hash of 'userpassword' with 'usersalt': " + hashPasswordWithSalt("userpassword", "usersalt"));
        System.out.println("Hash of 'adminpassword' with 'adminsalt': " + hashPasswordWithSalt("adminpassword", "adminsalt"));
        System.out.println("Hash of 'guestpassword' with 'guestsalt': " + hashPasswordWithSalt("guestpassword", "guestsalt"));
    }
}