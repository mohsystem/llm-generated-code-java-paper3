package CoT.gpt4o;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class Task77 {

    public static boolean downloadFileFromFTP(String hostname, String username, String password, String remoteFile) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(hostname);
            if (!ftpClient.login(username, password)) {
                ftpClient.logout();
                return false;
            }
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            try (FileOutputStream fos = new FileOutputStream(remoteFile)) {
                return ftpClient.retrieveFile(remoteFile, fos);
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
            System.out.println("Usage: java Task77 <hostname> <username> <password> <remoteFile>");
            return;
        }

        String hostname = args[0];
        String username = args[1];
        String password = args[2];
        String remoteFile = args[3];

        boolean success = downloadFileFromFTP(hostname, username, password, remoteFile);
        System.out.println("Download " + (success ? "successful" : "failed"));
    }
}