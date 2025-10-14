package Vanilla.openai;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task81 {
    public static boolean isCertMatchingHash(String certContent, String knownHash) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(certContent.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString().equals(knownHash);
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(isCertMatchingHash("cert1", "knownHash1")); // false
        System.out.println(isCertMatchingHash("cert2", "knownHash2")); // false
        System.out.println(isCertMatchingHash("cert3", "knownHash3")); // false
        System.out.println(isCertMatchingHash("cert4", "knownHash4")); // false
        System.out.println(isCertMatchingHash("cert5", "knownHash5")); // false
    }
}