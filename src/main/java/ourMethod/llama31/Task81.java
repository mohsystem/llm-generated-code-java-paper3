package ourMethod.llama31;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Task81 {
    public static void main(String[] args) throws CertificateException, NoSuchAlgorithmException, IOException {
        String certificatePath = "path/to/your/certificate.crt";
        String knownHash = "known_hash_value";

        X509Certificate certificate = loadCertificate(certificatePath);
        String calculatedHash = calculateHash(certificate);

        if (calculatedHash.equals(knownHash)) {
            System.out.println("The SSL certificate matches the known hash.");
        } else {
            System.out.println("The SSL certificate does not match the known hash.");
        }
    }

    private static X509Certificate loadCertificate(String certificatePath) throws CertificateException, IOException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        FileInputStream fis = new FileInputStream(certificatePath);
        X509Certificate certificate = (X509Certificate) cf.generateCertificate(fis);
        fis.close();
        return certificate;
    }

    private static String calculateHash(X509Certificate certificate) throws NoSuchAlgorithmException, CertificateEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(certificate.getEncoded());
        return bytesToHex(hashBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}