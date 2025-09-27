package ourMethod.gemini;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Task81 {

    public static boolean verifyCertificateHash(String certificatePath, String expectedHash, String hashAlgorithm)
            throws CertificateException, IOException, NoSuchAlgorithmException {

        // Create a certificate factory
        CertificateFactory cf = CertificateFactory.getInstance("X.509");

        // Read the certificate from the file
        FileInputStream fis = new FileInputStream(certificatePath);
        X509Certificate certificate = (X509Certificate) cf.generateCertificate(fis);
        fis.close();


        // Calculate the hash of the certificate
        MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
        byte[] certificateEncoded = certificate.getEncoded();
        byte[] calculatedHashBytes = md.digest(certificateEncoded);


        String calculatedHash = Base64.getEncoder().encodeToString(calculatedHashBytes);


        return calculatedHash.equals(expectedHash);
    }

    public static void main(String[] args) throws CertificateException, IOException, NoSuchAlgorithmException {

        String certPath = "test.cer"; // Replace with actual path

         // Test cases
        System.out.println(verifyCertificateHash(certPath, "jhasdasd", "SHA-256")); // Example hash, replace as needed
        System.out.println(verifyCertificateHash(certPath, "asdasd", "SHA-256")); // Example hash, replace as needed
        System.out.println(verifyCertificateHash(certPath, "sadd", "SHA-256")); // Example hash, replace as needed
        System.out.println(verifyCertificateHash(certPath, "sadadsdasdas", "SHA-256")); // Example hash, replace as needed
        System.out.println(verifyCertificateHash(certPath, "cxzxczxczxc", "SHA-256")); // Example hash, replace as needed
        
    }
}