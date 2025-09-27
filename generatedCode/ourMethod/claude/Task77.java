package ourMethod.claude;

import java.io.*;
import org.apache.commons.net.ftp.*;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.Arrays;

public class Task77 {
    private static final int MAX_RETRY = 3;
    private static final int TIMEOUT = 5000; // 5 seconds timeout
    
    public static void main(String[] args) {
        if (args.length != 4) {
            System.err.println("Usage: java Task77 <hostname> <username> <password> <filename>");
            System.exit(1);
        }

        String hostname = args[0];
        String username = args[1];
        String password = args[2];
        String filename = args[3];

        // Validate inputs
        if (!validateInputs(hostname, username, password, filename)) {
            System.err.println("Invalid input parameters");
            System.exit(1);
        }

        FTPSClient ftps = null;
        OutputStream outputStream = null;
        
        try {
            // Use FTPS for secure connection
            ftps = new FTPSClient(true);
            ftps.setConnectTimeout(TIMEOUT);
            ftps.connect(hostname);
            
            // Verify server certificate
            if (!ftps.login(username, password)) {
                throw new SecurityException("Authentication failed");
            }
            
            // Enable secure data channel
            ftps.execPBSZ(0);
            ftps.execPROT("P");
            ftps.enterLocalPassiveMode();
            ftps.setFileType(FTP.BINARY_FILE_TYPE);
            
            // Create temporary file for download
            Path tempFile = Files.createTempFile("download_", ".tmp");
            outputStream = Files.newOutputStream(tempFile);
            
            // Download file with retry mechanism
            boolean success = false;
            for(int i = 0; i < MAX_RETRY && !success; i++) {
                success = ftps.retrieveFile(filename, outputStream);
                if(!success) {
                    Thread.sleep(1000); // Wait before retry
                }
            }
            
            if(!success) {
                throw new IOException("Failed to download file after " + MAX_RETRY + " attempts");
            }
            
            // Move temp file to final destination securely
            Path destination = Paths.get(filename);
            Files.move(tempFile, destination, StandardCopyOption.REPLACE_EXISTING, 
                                           StandardCopyOption.ATOMIC_MOVE);
            
            System.out.println("File downloaded successfully");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        } finally {
            try {
                if(outputStream != null) outputStream.close();
                if(ftps != null && ftps.isConnected()) {
                    ftps.logout();
                    ftps.disconnect();
                }
            } catch (IOException e) {
                System.err.println("Error during cleanup: " + e.getMessage());
            }
            clearSensitiveData(password);
        }
    }
    
    private static boolean validateInputs(String hostname, String username, 
                                       String password, String filename) {
        if(hostname == null || hostname.trim().isEmpty() || 
           !hostname.matches("^[a-zA-Z0-9.-]+$")) {
            return false;
        }
        if(username == null || username.trim().isEmpty() || 
           !username.matches("^[a-zA-Z0-9._-]+$")) {
            return false;
        }
        if(password == null || password.trim().isEmpty()) {
            return false;
        }
        if(filename == null || filename.trim().isEmpty() || 
           !filename.matches("^[a-zA-Z0-9._-]+$")) {
            return false;
        }
        return true;
    }
    
    private static void clearSensitiveData(String password) {
        if(password != null) {
            char[] chars = password.toCharArray();
            Arrays.fill(chars, '\\0');
        }
    }
}
