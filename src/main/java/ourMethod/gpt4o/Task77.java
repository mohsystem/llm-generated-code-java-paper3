package ourMethod.gpt4o;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Task77 {
    public static boolean downloadFile(String server, String username, String password, String remoteFile, String localFile) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            try (OutputStream outputStream = new FileOutputStream(localFile)) {
                return ftpClient.retrieveFile(remoteFile, outputStream);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
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

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java Task77 <server> <username> <password> <remoteFile>");
            return;
        }
        
        String server = args[0];
        String username = args[1];
        String password = args[2];
        String remoteFile = args[3];
        String localFile = remoteFile;  // Download to the same name locally

        if (downloadFile(server, username, password, remoteFile, localFile)) {
            System.out.println("File downloaded successfully.");
        } else {
            System.out.println("Failed to download the file.");
        }
    }
}