package CoT.llama31;
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

        // Convert byte array to hex string
        StringBuilder hexString = new StringBuilder();
        for (byte b : certHash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString().equals(knownHash);
    }

    public static void main(String[] args) throws Exception {
        String certificatePath = "path/to/your/certificate.crt";
        String knownHash = "your_known_hash_here";

        // Test cases
        System.out.println(checkCertificateHash(certificatePath, knownHash));
        System.out.println(checkCertificateHash(certificatePath, "wrong_hash"));
        System.out.println(checkCertificateHash("wrong_path", knownHash));
        System.out.println(checkCertificateHash("wrong_path", "wrong_hash"));
        System.out.println(checkCertificateHash(null, knownHash));
    }
}