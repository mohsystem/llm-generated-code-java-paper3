package Vanilla.claude;

// FTP operations require external libraries in Java
// Requires Apache Commons Net library
import org.apache.commons.net.ftp.FTPClient;
import java.io.*;

public class Task77 {
    public static boolean downloadFromFTP(String host, String user, String pass, String filename) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(host);
            ftpClient.login(user, pass);
            
            // Download file
            File downloadFile = new File(filename);
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(downloadFile));
            boolean success = ftpClient.retrieveFile(filename, outputStream);
            outputStream.close();

            ftpClient.logout();
            ftpClient.disconnect();
            return success;
            
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        downloadFromFTP("ftp.example.com", "user1", "pass1", "file1.txt");
        downloadFromFTP("ftp.test.com", "user2", "pass2", "data.csv"); 
        downloadFromFTP("ftp.sample.net", "admin", "admin123", "report.pdf");
        downloadFromFTP("ftp.demo.org", "ftpuser", "ftppass", "backup.zip");
        downloadFromFTP("ftp.secure.com", "root", "rootpass", "config.xml");
    }
}
