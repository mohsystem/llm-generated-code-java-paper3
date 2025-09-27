package CoT.gemini;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Task81 {

    public static boolean verifyCertificateHash(String certificatePath, String expectedHash) {
        try (FileInputStream fis = new FileInputStream(certificatePath)) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate) cf.generateCertificate(fis);

            MessageDigest md = MessageDigest.getInstance("SHA-256"); // Or the algorithm used for the expectedHash
            byte[] certificateHashBytes = md.digest(certificate.getEncoded());
            String certificateHash = Base64.getEncoder().encodeToString(certificateHashBytes);

            return certificateHash.equals(expectedHash);

        } catch (IOException | CertificateException | NoSuchAlgorithmException e) {
            System.err.println("Error verifying certificate: " + e.getMessage());
            return false;
        }
    }


    public static void main(String[] args) {
        // Test cases (replace with actual certificate paths and hashes)
        String certPath1 = "test1.cer"; // Example
        String expectedHash1 = "someHash1"; // Example
        System.out.println("Test 1: " + verifyCertificateHash(certPath1, expectedHash1));

        String certPath2 = "test2.cer"; // Example
        String expectedHash2 = "someHash2"; // Example
        System.out.println("Test 2: " + verifyCertificateHash(certPath2, expectedHash2));

        String certPath3 = "test3.cer"; // Example
        String expectedHash3 = "someHash3"; // Example
        System.out.println("Test 3: " + verifyCertificateHash(certPath3, expectedHash3));

        String certPath4 = "test4.cer"; // Example
        String expectedHash4 = "someHash4"; // Example
        System.out.println("Test 4: " + verifyCertificateHash(certPath4, expectedHash4));

        String certPath5 = "test5.cer"; // Example
        String expectedHash5 = "someHash5"; // Example
        System.out.println("Test 5: " + verifyCertificateHash(certPath5, expectedHash5));


    }
}