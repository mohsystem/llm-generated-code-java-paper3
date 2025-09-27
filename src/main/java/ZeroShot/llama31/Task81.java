package ZeroShot.llama31;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Task81 {

    public static boolean checkCertificateHash(String certificatePath, String knownHash) throws Exception {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        FileInputStream fis = new FileInputStream(new File(certificatePath));
        X509Certificate cert = (X509Certificate) cf.generateCertificate(fis);
        fis.close();

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] certBytes = cert.getEncoded();
        byte[] certHash = md.digest(certBytes);

        StringBuilder sb = new StringBuilder();
        for (byte b : certHash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString().equals(knownHash);
    }

    public static void main(String[] args) throws Exception {
        String certificatePath = "path/to/your/certificate.crt";
        String knownHash = "your_known_hash_here";

        System.out.println("Does the certificate match the known hash? " + checkCertificateHash(certificatePath, knownHash));

        // Test cases
        System.out.println("Test Case 1: " + checkCertificateHash("path/to/cert1.crt", "hash1"));
        System.out.println("Test Case 2: " + checkCertificateHash("path/to/cert2.crt", "hash2"));
        System.out.println("Test Case 3: " + checkCertificateHash("path/to/cert3.crt", "hash3"));
        System.out.println("Test Case 4: " + checkCertificateHash("path/to/cert4.crt", "hash4"));
        System.out.println("Test Case 5: " + checkCertificateHash("path/to/cert5.crt", "hash5"));
    }
}