package CoT.codestral;
import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public class Task81 {
    public static boolean isHashMatch(X509Certificate cert, String knownHash) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] certBytes = cert.getEncoded();
        byte[] hashBytes = md.digest(certBytes);
        String certHash = bytesToHex(hashBytes);
        return certHash.equals(knownHash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) throws Exception {
        // Test cases here
    }
}