package ourMethod.gemini;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


public class Task77 {

    public static void downloadSensitiveFile(String hostname, String username, String password, String remoteFilePath, String localFilePath) throws SocketException, IOException {
        FTPClient ftpClient = new FTPClient();

        try {
            ftpClient.connect(hostname);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.err.println("FTP connection failed: " + hostname);
                return;
            }

            if (!ftpClient.login(username, password)) {
                System.err.println("FTP login failed: " + username);
                return;
            }

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();


            try (FileOutputStream fos = new FileOutputStream(localFilePath)) {
                if (!ftpClient.retrieveFile(remoteFilePath, fos)) {
                    System.err.println("Failed to download file: " + remoteFilePath);
                } else {
                    System.out.println("File downloaded successfully: " + localFilePath);
                }
            }

        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.logout();
                    ftpClient.disconnect();
                } catch (IOException ex) {
                    //
                }
            }
        }
    }


    public static void main(String[] args) throws SocketException, IOException {
      
        downloadSensitiveFile("test.rebex.net", "demo", "password", "/pub/example/readme.txt", "readme.txt");
        downloadSensitiveFile("test.rebex.net", "demo", "password", "/pub/example/imap-console-client.png", "imap-console-client.png");
        downloadSensitiveFile("test.rebex.net", "demo", "password", "/pub/example/WinFormClient.png", "WinFormClient.png");
        downloadSensitiveFile("test.rebex.net", "demo", "password", "/pub/example/latex-report.pdf", "latex-report.pdf");
        downloadSensitiveFile("test.rebex.net", "demo", "password", "/pub/example/mail-merge.docx", "mail-merge.docx");


    }
}