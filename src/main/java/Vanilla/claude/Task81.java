package Vanilla.claude;

import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.io.FileInputStream;
import java.io.File;
import javax.xml.bind.DatatypeConverter;

public class Task81 {
    public static boolean checkCertificateHash(String certPath, String expectedHash) {
        try {
            // Load certificate
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            FileInputStream fis = new FileInputStream(new File(certPath));
            X509Certificate cert = (X509Certificate) cf.generateCertificate(fis);
            
            // Calculate hash
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] der = cert.getEncoded();
            md.update(der);
            byte[] digest = md.digest();
            String calculatedHash = DatatypeConverter.printHexBinary(digest).toLowerCase();
            
            // Compare hashes
            return calculatedHash.equals(expectedHash.toLowerCase());
            
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] certs = {
            "cert1.pem",
            "cert2.pem", 
            "cert3.pem",
            "cert4.pem",
            "cert5.pem"
        };
        
        String[] hashes = {
            "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6",
            "b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a1",
            "c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a1b2",
            "d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a1b2c3",
            "e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a1b2c3d4"
        };
        
        for(int i = 0; i < 5; i++) {
            System.out.println("Test case " + (i+1) + ": " + 
                checkCertificateHash(certs[i], hashes[i]));
        }
    }
}
