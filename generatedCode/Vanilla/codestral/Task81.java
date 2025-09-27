package Vanilla.codestral;
import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Task81 {
    public static boolean isCertificateValid(X509Certificate cert, String knownHash) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] certHash = md.digest(cert.getEncoded());
        String base64CertHash = Base64.getEncoder().encodeToString(certHash);
        return base64CertHash.equals(knownHash);
    }

    public static void main(String[] args) {
        // Test cases here
    }
}