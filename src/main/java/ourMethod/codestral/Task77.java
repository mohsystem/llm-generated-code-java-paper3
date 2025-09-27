package ourMethod.codestral;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Task77 {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java Task77 <hostname> <username> <password> <remoteFile>");
            return;
        }

        String hostname = args[0];
        String username = args[1];
        String password = args[2];
        String remoteFile = args[3];

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(hostname);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Failed to connect to the FTP server.");
                ftpClient.disconnect();
                return;
            }

            boolean success = ftpClient.login(username, password);
            if (!success) {
                System.out.println("Failed to login to the FTP server.");
                ftpClient.disconnect();
                return;
            }

            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            String localFile = remoteFile;
            InputStream inputStream = ftpClient.retrieveFileStream(remoteFile);
            OutputStream outputStream = new FileOutputStream(localFile);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            success = ftpClient.completePendingCommand();
            if (success) {
                System.out.println("File downloaded successfully.");
            } else {
                System.out.println("Failed to download the file.");
            }

            inputStream.close();
            outputStream.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}