package ZeroShot.claude;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import java.io.*;

public class Task77 {
    public static boolean downloadFromFTP(String server, String username, String password, String remoteFile) {
        FTPClient ftpClient = new FTPClient();
        try {
            // Enable secure mode
            ftpClient.setUseEPSVwithIPv4(true);
            ftpClient.connect(server);
            
            // Check connection status
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                return false;
            }
            
            // Login with credentials
            if (!ftpClient.login(username, password)) {
                ftpClient.disconnect();
                return false;
            }
            
            // Set protection buffer size
            ftpClient.setBufferSize(1024 * 1024);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            
            // Download file
            File downloadFile = new File(new File(remoteFile).getName());
            try (OutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(downloadFile))) {
                if (!ftpClient.retrieveFile(remoteFile, outputStream)) {
                    return false;
                }
            }
            
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                // Handle exception
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java Task77 <server> <username> <password> <remoteFile>");
            return;
        }

        // Test cases
        String[][] testCases = {
            {args[0], args[1], args[2], args[3]},
            {"ftp.example.com", "user1", "pass1", "/files/doc1.txt"},
            {"ftp.test.com", "user2", "pass2", "/secure/file2.pdf"},
            {"ftp.secure.com", "user3", "pass3", "/docs/report.docx"},
            {"ftp.company.com", "user4", "pass4", "/data/info.xlsx"}
        };

        for (String[] testCase : testCases) {
            boolean result = downloadFromFTP(testCase[0], testCase[1], testCase[2], testCase[3]);
            System.out.println("Download " + (result ? "successful" : "failed") + 
                             " for file: " + testCase[3]);
        }
    }
}
