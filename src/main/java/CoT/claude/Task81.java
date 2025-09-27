package CoT.claude;

import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;

public class Task81 {
    public static boolean verifyCertificateHash(String certPath, String expectedHash) {
        try {
            // Load the certificate
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            FileInputStream fis = new FileInputStream(certPath);
            X509Certificate cert = (X509Certificate) cf.generateCertificate(fis);
            fis.close();

            // Calculate hash
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] derEncodedCert = cert.getEncoded();
            byte[] digest = md.digest(derEncodedCert);
            
            // Convert to hex string
            StringBuilder sb = new StringBuilder();
            for(byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            String actualHash = sb.toString();
            
            // Compare hashes
            return expectedHash.equalsIgnoreCase(actualHash);
            
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String certPath = "cert.pem";
        String[] testHashes = {
            "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
            "a3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
            "b3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
            "c3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
            "d3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"
        };
        
        for(int i = 0; i < testHashes.length; i++) {
            System.out.println("Test case " + (i+1) + ": " + 
                verifyCertificateHash(certPath, testHashes[i]));
        }
    }
}
