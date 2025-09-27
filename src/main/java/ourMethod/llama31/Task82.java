package ourMethod.llama31;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class Task82 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "farm1990M0O";
        String salt = "f1nd1ngn3m0";

        // Prepending the salt
        String saltedPassword = salt + password;
        String hash1 = hash(saltedPassword);

        // Appending the salt
        saltedPassword = password + salt;
        String hash2 = hash(saltedPassword);

        System.out.println("Hash with prepended salt: " + hash1);
        System.out.println("Hash with appended salt: " + hash2);
    }

    public static String hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashBytes);
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}