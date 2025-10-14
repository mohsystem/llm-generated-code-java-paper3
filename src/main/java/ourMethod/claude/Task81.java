package ourMethod.claude;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public class Task81 {
    
    /**
     * Verifies if the certificate hash matches the expected hash using constant-time comparison.
     * 
     * @param certificateBytes The certificate bytes to verify
     * @param expectedHashHex The expected SHA-256 hash in hexadecimal format
     * @return true if the hash matches, false otherwise
     */
    public static boolean verifyCertificateHash(byte[] certificateBytes, String expectedHashHex) {
        if (certificateBytes == null || certificateBytes.length == 0) {
            return false;
        }
        if (expectedHashHex == null || expectedHashHex.isEmpty()) {
            return false;
        }
        
        // Validate hex format
        if (!expectedHashHex.matches("^[0-9a-fA-F]+$") || expectedHashHex.length() != 64) {
            return false;
        }
        
        try {
            // Parse certificate
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            try (ByteArrayInputStream bais = new ByteArrayInputStream(certificateBytes)) {
                Certificate cert = cf.generateCertificate(bais);
                
                if (!(cert instanceof X509Certificate)) {
                    return false;
                }
                
                X509Certificate x509Cert = (X509Certificate) cert;
                
                // Check certificate validity period
                x509Cert.checkValidity();
                
                // Compute SHA-256 hash
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] certHash = digest.digest(cert.getEncoded());
                
                // Convert to hex
                StringBuilder hexString = new StringBuilder();
                for (byte b : certHash) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) {
                        hexString.append('0');
                    }
                    hexString.append(hex);
                }
                
                String actualHashHex = hexString.toString();
                
                // Constant-time comparison
                return constantTimeEquals(actualHashHex.toLowerCase(), expectedHashHex.toLowerCase());
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Constant-time string comparison to prevent timing attacks.
     */
    private static boolean constantTimeEquals(String a, String b) {
        if (a == null || b == null) {
            return false;
        }
        
        byte[] aBytes = a.getBytes(StandardCharsets.UTF_8);
        byte[] bBytes = b.getBytes(StandardCharsets.UTF_8);
        
        return MessageDigest.isEqual(aBytes, bBytes);
    }
    
    /**
     * Loads a certificate from a file path.
     */
    public static byte[] loadCertificateFromFile(String filePath) throws IOException {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("Certificate file not found: " + filePath);
        }
        
        if (file.length() > 10 * 1024 * 1024) { // 10MB limit
            throw new IOException("Certificate file too large");
        }
        
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }
    
    public static void main(String[] args) {
        // Test case 1: Valid certificate matching hash
        System.out.println("Test Case 1: Valid certificate with matching hash");
        try {
            String testCert1 = "-----BEGIN CERTIFICATE-----\\n" +
                "MIICpDCCAYwCCQDU+pQ3ZUD30jANBgkqhkiG9w0BAQsFADAUMRIwEAYDVQQDDAls\\n" +
                "b2NhbGhvc3QwHhcNMjQwMTAxMDAwMDAwWhcNMjUwMTAxMDAwMDAwWjAUMRIwEAYD\\n" +
                "VQQDDAlsb2NhbGhvc3QwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQC7\\n" +
                "VJTUt9Us8cKjMzEfYyjiWA4R4/M2bS1+fWIcPm9z4Hj1C4C1eFpQ2PQmXYLX3z1k\\n" +
                "YBGKMTMPiBm/XZ0dGKE3O4QU7YdZwXKJZL0cU4ADMBsGA1UdEQQUMBKCCWxvY2Fs\\n" +
                "aG9zdIcEfwAAATANBgkqhkiG9w0BAQsFAAOCAQEAKDqG1x2hP+tJ3L0dHFMm3N9A\\n" +
                "-----END CERTIFICATE-----";
            
            byte[] certBytes1 = testCert1.getBytes(StandardCharsets.UTF_8);
            String expectedHash1 = "abcdef1234567890abcdef1234567890abcdef1234567890abcdef1234567890";
            boolean result1 = verifyCertificateHash(certBytes1, expectedHash1);
            System.out.println("Result: " + result1 + " (Expected: false - different hash)\\n");
        } catch (Exception e) {
            System.out.println("Test failed with exception\\n");
        }
        
        // Test case 2: Invalid hex format
        System.out.println("Test Case 2: Invalid hex format in expected hash");
        byte[] certBytes2 = "test".getBytes(StandardCharsets.UTF_8);
        String invalidHash = "ZZZZZZ";
        boolean result2 = verifyCertificateHash(certBytes2, invalidHash);
        System.out.println("Result: " + result2 + " (Expected: false - invalid hex)\\n");
        
        // Test case 3: Null certificate
        System.out.println("Test Case 3: Null certificate bytes");
        boolean result3 = verifyCertificateHash(null, "abcdef1234567890abcdef1234567890abcdef1234567890abcdef1234567890");
        System.out.println("Result: " + result3 + " (Expected: false - null input)\\n");
        
        // Test case 4: Empty expected hash
        System.out.println("Test Case 4: Empty expected hash");
        byte[] certBytes4 = "test".getBytes(StandardCharsets.UTF_8);
        boolean result4 = verifyCertificateHash(certBytes4, "");
        System.out.println("Result: " + result4 + " (Expected: false - empty hash)\\n");
        
        // Test case 5: Hash with wrong length
        System.out.println("Test Case 5: Hash with incorrect length");
        byte[] certBytes5 = "test".getBytes(StandardCharsets.UTF_8);
        String shortHash = "abcdef";
        boolean result5 = verifyCertificateHash(certBytes5, shortHash);
        System.out.println("Result: " + result5 + " (Expected: false - wrong length)\\n");
    }
}
