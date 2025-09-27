package ourMethod.claude;

import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Task81 {
    public static boolean verifyCertificateHash(byte[] certificateData, String expectedHash) {
        if (certificateData == null || expectedHash == null || expectedHash.trim().isEmpty()) {
            return false;
        }
        
        try {
            // Create certificate from bytes
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            InputStream certStream = new ByteArrayInputStream(certificateData);
            Certificate cert = cf.generateCertificate(certStream);
            
            // Generate SHA-256 hash
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(cert.getEncoded());
            
            // Convert hash to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            // Compare hashes (case-insensitive)
            return hexString.toString().equalsIgnoreCase(expectedHash.trim());
            
        } catch (CertificateException | java.security.NoSuchAlgorithmException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            // Test cases
            String expectedHash = "a1b2c3d4e5f6g7h8i9j0"; // Example hash
            
            // Test case 1: Valid certificate with matching hash
            try (FileInputStream fis = new FileInputStream("test_cert.cer")) {
                byte[] certData = fis.readAllBytes();
                System.out.println("Test 1: " + verifyCertificateHash(certData, expectedHash));
            }
            
            // Test case 2: Null certificate
            System.out.println("Test 2: " + verifyCertificateHash(null, expectedHash));
            
            // Test case 3: Null hash
            try (FileInputStream fis = new FileInputStream("test_cert.cer")) {
                byte[] certData = fis.readAllBytes();
                System.out.println("Test 3: " + verifyCertificateHash(certData, null));
            }
            
            // Test case 4: Empty hash
            try (FileInputStream fis = new FileInputStream("test_cert.cer")) {
                byte[] certData = fis.readAllBytes();
                System.out.println("Test 4: " + verifyCertificateHash(certData, ""));
            }
            
            // Test case 5: Invalid certificate data
            System.out.println("Test 5: " + verifyCertificateHash(new byte[]{1,2,3}, expectedHash));
            
        } catch (IOException e) {
            System.err.println("Error reading certificate file: " + e.getMessage());
        }
    }
}
