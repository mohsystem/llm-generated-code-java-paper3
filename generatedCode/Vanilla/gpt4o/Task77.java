package Vanilla.gpt4o;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class Task77 {
    public static boolean downloadFile(String server, int port, String user, String pass, String remoteFilePath, String downloadPath) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            boolean login = ftpClient.login(user, pass);
            if (!login) {
                return false;
            }
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            try (FileOutputStream fos = new FileOutputStream(downloadPath)) {
                return ftpClient.retrieveFile(remoteFilePath, fos);
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
        if (args.length != 5) {
            System.out.println("Usage: java Task77 <server> <port> <user> <pass> <remoteFilePath>");
            return;
        }
        String server = args[0];
        int port = Integer.parseInt(args[1]);
        String user = args[2];
        String pass = args[3];
        String remoteFilePath = args[4];
        String downloadPath = remoteFilePath.substring(remoteFilePath.lastIndexOf('/') + 1);

        boolean success = downloadFile(server, port, user, pass, remoteFilePath, downloadPath);
        System.out.println("Download " + (success ? "successful" : "failed"));
    }
}