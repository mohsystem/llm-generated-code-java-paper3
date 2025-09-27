package ZeroShot.codestral;
import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Task81 {
    public static boolean isCertificateValid(X509Certificate cert, String knownHash) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(cert.getEncoded());
            String certHash = Base64.getEncoder().encodeToString(digest);
            return certHash.equals(knownHash);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Add test cases here
    }
}