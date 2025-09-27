package ourMethod.codestral;
import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public class Task81 {
    public static boolean isCertificateHashMatch(X509Certificate cert, String knownHash) {
        try {
            byte[] certBytes = cert.getEncoded();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] certHash = md.digest(certBytes);
            String certHashHex = bytesToHex(certHash);
            return certHashHex.equals(knownHash);
        } catch (CertificateEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        // Replace with actual test cases
    }
}