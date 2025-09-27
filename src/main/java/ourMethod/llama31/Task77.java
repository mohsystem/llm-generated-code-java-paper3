package ourMethod.llama31;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Task77 {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java Task77 <hostname> <username> <password> <filename>");
            return;
        }

        String hostname = args[0];
        String username = args[1];
        String password = args[2];
        String filename = args[3];

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(hostname);
            if (!ftpClient.login(username, password)) {
                System.out.println("Login failed");
                return;
            }

            System.out.println("Connected to FTP server");

            if (!ftpClient.setFileType(FTP.BINARY_FILE_TYPE)) {
                System.out.println("Failed to set file type to binary");
                return;
            }

            File localFile = new File(filename);
            OutputStream outputStream = new FileOutputStream(localFile);

            if (!ftpClient.retrieveFile(filename, outputStream)) {
                System.out.println("Failed to download file");
                return;
            }

            outputStream.close();
            System.out.println("File downloaded successfully");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.logout();
                    ftpClient.disconnect();
                } catch (IOException e) {
                    System.out.println("Error disconnecting from FTP server: " + e.getMessage());
                }
            }
        }
    }
}