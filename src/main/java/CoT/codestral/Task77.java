package CoT.codestral;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Task77 {
    public static void main(String[] args) {
        String hostname = args[0];
        String username = args[1];
        String password = args[2];
        String remoteFile = args[3];
        String localFile = args[4];

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(hostname);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            InputStream inputStream = ftpClient.retrieveFileStream(remoteFile);
            OutputStream outputStream = new FileOutputStream(localFile);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            boolean success = ftpClient.completePendingCommand();
            if (success) {
                System.out.println("File downloaded successfully.");
            } else {
                System.out.println("File download failed.");
            }

            ftpClient.logout();
            ftpClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}