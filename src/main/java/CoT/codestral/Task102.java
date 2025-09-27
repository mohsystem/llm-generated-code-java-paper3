package CoT.codestral;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Task102 {
    public static void updatePassword(String username, String password) {
        String hashedPassword = getSecurePassword(password);
        // Database update code here, using prepared statements to prevent SQL injection
    }

    public static String getSecurePassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static void main(String[] args) {
        // Test cases
        updatePassword("user1", "password1");
        updatePassword("user2", "password2");
        updatePassword("user3", "password3");
        updatePassword("user4", "password4");
        updatePassword("user5", "password5");
    }
}