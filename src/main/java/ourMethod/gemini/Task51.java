package ourMethod.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task51 {

    public static String encrypt(String text) {
        try {
            // Generate a secure random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            // Use SHA-256 for hashing
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            md.update(text.getBytes());
            byte[] hash = md.digest();


            // Combine salt and hash for storage/transmission
            byte[] saltAndHash = new byte[salt.length + hash.length];
            System.arraycopy(salt, 0, saltAndHash, 0, salt.length);
            System.arraycopy(hash, 0, saltAndHash, salt.length, hash.length);

            return Base64.getEncoder().encodeToString(saltAndHash);

        } catch (NoSuchAlgorithmException e) {
            // Handle exception appropriately, e.g., log and return null or rethrow
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String[] testCases = {"Hello", "World", "Test1", "Test2", "Test3"};
        for (String testCase : testCases) {
            String encrypted = encrypt(testCase);
            System.out.println("Original: " + testCase + ", Encrypted: " + encrypted);
        }

    }
}