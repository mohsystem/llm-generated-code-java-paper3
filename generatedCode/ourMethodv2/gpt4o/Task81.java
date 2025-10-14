package ourMethodv2.gpt4o;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.io.ByteArrayInputStream;
import javax.xml.bind.DatatypeConverter;

public class Task81 {

    public static boolean doesCertificateMatchHash(byte[] certBytes, String knownHash) {
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(certBytes));
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] certHash = md.digest(cert.getEncoded());
            String certHashString = DatatypeConverter.printHexBinary(certHash);
            return certHashString.equalsIgnoreCase(knownHash);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(doesCertificateMatchHash(new byte[]{/* sample cert bytes */}, "knownHash1"));
        System.out.println(doesCertificateMatchHash(new byte[]{/* sample cert bytes */}, "knownHash2"));
        System.out.println(doesCertificateMatchHash(new byte[]{/* sample cert bytes */}, "knownHash3"));
        System.out.println(doesCertificateMatchHash(new byte[]{/* sample cert bytes */}, "knownHash4"));
        System.out.println(doesCertificateMatchHash(new byte[]{/* sample cert bytes */}, "knownHash5"));
    }
}