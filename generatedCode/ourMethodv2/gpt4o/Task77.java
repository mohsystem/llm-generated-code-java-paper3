package ourMethodv2.gpt4o;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task77 {
    public static void downloadFileFromFTP(String server, String user, String pass, String filename) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server);
            ftpClient.login(user, pass);

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            try (FileOutputStream fos = new FileOutputStream(filename)) {
                ftpClient.retrieveFile(filename, fos);
            }

            ftpClient.logout();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: <hostname> <username> <password> <filename>");
            return;
        }
        downloadFileFromFTP(args[0], args[1], args[2], args[3]);
    }
}