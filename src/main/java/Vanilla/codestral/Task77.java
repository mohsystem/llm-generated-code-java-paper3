package Vanilla.codestral;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTPClient;

public class Task77 {
    public static void main(String[] args) {
        String server = args[0];
        String user = args[1];
        String pass = args[2];
        String file = args[3];

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server);
            ftpClient.login(user, pass);

            OutputStream outputStream = new FileOutputStream(file);
            boolean success = ftpClient.retrieveFile(file, outputStream);
            outputStream.close();

            if (success) {
                System.out.println("File #" + file + " has been downloaded successfully.");
            }
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