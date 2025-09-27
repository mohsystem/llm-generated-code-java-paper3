package Vanilla.llama31;
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
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        FileInputStream fis = new FileInputStream(new File(certificatePath));
        X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(fis);
        fis.close();

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] certificateBytes = certificate.getEncoded();
        byte[] hashBytes = md.digest(certificateBytes);
        StringBuilder actualHash = new StringBuilder();
        for (byte b : hashBytes) {
            actualHash.append(String.format("%02x", b));
        }

        return actualHash.toString().equals(knownHash);
    }

    public static void main(String[] args) throws Exception {
        String[] certificatePaths = {"path/to/cert1.crt", "path/to/cert2.crt", "path/to/cert3.crt", "path/to/cert4.crt", "path/to/cert5.crt"};
        String[] knownHashes = {"knownhash1", "knownhash2", "knownhash3", "knownhash4", "knownhash5"};

        for (int i = 0; i < 5; i++) {
            boolean result = checkCertificateHash(certificatePaths[i], knownHashes[i]);
            System.out.println("Certificate " + (i + 1) + " matches: " + result);
        }
    }
}