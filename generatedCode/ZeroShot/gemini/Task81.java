package ZeroShot.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Task81 {

    public static boolean verifyCertificateHash(X509Certificate certificate, String expectedHash) {
        try {
            byte[] certificateBytes = certificate.getEncoded();
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // Or other algorithm
            byte[] calculatedHashBytes = md.digest(certificateBytes);
            String calculatedHash = Base64.getEncoder().encodeToString(calculatedHashBytes);
            return calculatedHash.equals(expectedHash);
        } catch (NoSuchAlgorithmException | CertificateEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        // Test cases (replace with actual certificate and hash values)
        // In a real application, you would load the certificate from a file or other source.
        X509Certificate cert1 = null; // Replace with a valid certificate object
        String hash1 = ""; // Replace with the expected hash for cert1

        System.out.println("Test 1: " + verifyCertificateHash(cert1, hash1));
        // ... add more test cases ...
    }
}