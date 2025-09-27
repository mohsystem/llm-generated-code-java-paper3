package CoT.gpt4o;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Task81 {
    public static boolean checkSSLCertificate(String certificateContent, String knownHash) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(certificateContent.getBytes());
            String encodedHash = Base64.getEncoder().encodeToString(hash);
            return encodedHash.equals(knownHash);
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String cert1 = "certificateContent1";
        String hash1 = "knownHash1";
        String cert2 = "certificateContent2";
        String hash2 = "knownHash2";
        String cert3 = "certificateContent3";
        String hash3 = "knownHash3";
        String cert4 = "certificateContent4";
        String hash4 = "knownHash4";
        String cert5 = "certificateContent5";
        String hash5 = "knownHash5";
        
        System.out.println(checkSSLCertificate(cert1, hash1)); // Output: false
        System.out.println(checkSSLCertificate(cert2, hash2)); // Output: false
        System.out.println(checkSSLCertificate(cert3, hash3)); // Output: false
        System.out.println(checkSSLCertificate(cert4, hash4)); // Output: false
        System.out.println(checkSSLCertificate(cert5, hash5)); // Output: false
    }
}