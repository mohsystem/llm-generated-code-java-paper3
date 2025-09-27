package ZeroShot.claude;

import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.bind.DatatypeConverter;

public class Task81 {
    public static boolean checkCertificateHash(String certPath, String expectedHash) {
        try {
            // Load certificate
            FileInputStream fis = new FileInputStream(certPath);
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(fis);
            
            // Calculate hash
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] derCert = cert.getEncoded();
            md.update(derCert);
            String calculatedHash = DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
            
            // Compare hashes
            return calculatedHash.equals(expectedHash.toLowerCase());
            
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String certPath = "test.crt"; // Replace with actual cert path
        String[] testHashes = {
            "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", // Valid hash
            "a3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", // Invalid hash
            "b3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", // Invalid hash
            "c3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", // Invalid hash
            "d3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"  // Invalid hash
        };

        for(int i = 0; i < testHashes.length; i++) {
            System.out.println("Test case " + (i+1) + ": " + 
                checkCertificateHash(certPath, testHashes[i]));
        }
    }
}
