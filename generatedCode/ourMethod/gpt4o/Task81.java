package ourMethod.gpt4o;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.io.ByteArrayInputStream;

public class Task81 {
    
    public boolean isCertHashMatching(String certString, String knownHash) {
        try {
            byte[] decodedCert = Base64.getDecoder().decode(certString);
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate) certFactory.generateCertificate(new ByteArrayInputStream(decodedCert));
            byte[] certEncoded = certificate.getEncoded();
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] certHash = md.digest(certEncoded);
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : certHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString().equalsIgnoreCase(knownHash);
        } catch (CertificateException | NoSuchAlgorithmException e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Task81 task = new Task81();
        // Test Cases
        System.out.println(task.isCertHashMatching("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA...", "knownhash1"));
        System.out.println(task.isCertHashMatching("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEB...", "knownhash2"));
        System.out.println(task.isCertHashMatching("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEC...", "knownhash3"));
        System.out.println(task.isCertHashMatching("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQED...", "knownhash4"));
        System.out.println(task.isCertHashMatching("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEE...", "knownhash5"));
    }
}