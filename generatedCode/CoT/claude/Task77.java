package CoT.claude;

import java.io.*;
import org.apache.commons.net.ftp.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Task77 {
    private static final String ENCRYPTION_KEY = "MySuperSecretKey"; // Should be stored securely
    
    public static boolean downloadFromFTP(String hostname, String username, String password, String filename) {
        FTPClient ftpClient = new FTPClient();
        try {
            // Enable secure FTP connection
            ftpClient.setUseEPSVwithIPv4(true);
            ftpClient.setAutodetectUTF8(true);
            ftpClient.connect(hostname, 21);
            
            // Validate credentials before login
            if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Invalid credentials");
            }
            
            // Login with encrypted credentials
            String decryptedPassword = decrypt(password);
            boolean loggedIn = ftpClient.login(username, decryptedPassword);
            
            if (!loggedIn) {
                System.err.println("Failed to login to FTP server");
                return false;
            }
            
            // Set protection buffer size
            ftpClient.setBufferSize(1024);
            ftpClient.enterLocalPassiveMode();
            
            // Validate filename
            if (filename == null || filename.isEmpty() || !isValidFilename(filename)) {
                throw new IllegalArgumentException("Invalid filename");
            }
            
            // Download file with restricted permissions
            File downloadFile = new File(filename);
            try (FileOutputStream fos = new FileOutputStream(downloadFile)) {
                boolean success = ftpClient.retrieveFile(filename, fos);
                if (success) {
                    // Set restrictive file permissions
                    downloadFile.setReadable(true, true);
                    downloadFile.setWritable(true, true);
                    downloadFile.setExecutable(false);
                    return true;
                }
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException e) {
                System.err.println("Error closing FTP connection: " + e.getMessage());
            }
        }
        return false;
    }
    
    private static String decrypt(String encryptedText) throws Exception {
        SecretKey key = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }
    
    private static boolean isValidFilename(String filename) {
        return filename.matches("^[a-zA-Z0-9._-]+$");
    }
    
    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
            {"ftp.example.com", "user1", "encryptedPass1", "file1.txt"},
            {"ftp.test.com", "user2", "encryptedPass2", "document.pdf"},
            {"ftp.secure.com", "user3", "encryptedPass3", "data.csv"},
            {"ftp.server.com", "user4", "encryptedPass4", "report.doc"},
            {"ftp.domain.com", "user5", "encryptedPass5", "backup.zip"}
        };
        
        for (String[] testCase : testCases) {
            System.out.println("Testing FTP download with: " + String.join(", ", testCase));
            boolean result = downloadFromFTP(testCase[0], testCase[1], testCase[2], testCase[3]);
            System.out.println("Result: " + result + "\\n");
        }
    }
}
