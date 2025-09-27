package Vanilla.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Task81 {

    public static boolean verifySSLCertificateHash(X509Certificate certificate, String expectedHash, String algorithm) throws NoSuchAlgorithmException, CertificateEncodingException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] certHash = md.digest(certificate.getEncoded());
        String calculatedHash = Base64.getEncoder().encodeToString(certHash);
        return calculatedHash.equals(expectedHash);
    }

    public static void main(String[] args) throws Exception {
        // Test cases (replace with actual certificates and hashes)
        X509Certificate cert1 = null; // Load certificate 1
        String expectedHash1 = "";  // Expected hash for cert1
        String algorithm1 = "SHA-256";

        // ... (Load certificates 2-5 and their expected hashes similarly)

        boolean result1 = verifySSLCertificateHash(cert1, expectedHash1, algorithm1);
        System.out.println("Test 1: " + result1);

        // ... (Perform tests for certificates 2-5 similarly)
    }
}