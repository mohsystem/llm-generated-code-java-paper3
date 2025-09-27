package ourMethod.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Task82 {

    public static byte[] getSaltedPasswordHash(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        md.update(password.getBytes());
        return md.digest();
    }

    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        String[] passwords = {"password123", "test", "anotherPassword", "123456", "complexPassword"};

        for (String password : passwords) {
            byte[] salt = generateSalt();
            byte[] saltedHash = getSaltedPasswordHash(password, salt);
            System.out.println("Password: " + password);
            System.out.println("Salt: " + bytesToHex(salt));
            System.out.println("Salted Hash: " + bytesToHex(saltedHash));
            System.out.println();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}