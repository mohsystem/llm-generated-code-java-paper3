package Vanilla.gemini;
import java.io.*;
import java.net.*;

public class Task77 {

    public static void downloadFile(String hostname, String username, String password, String filename) throws IOException {
        FTPClient ftpClient = new FTPClient();

        try {
            ftpClient.connect(hostname);
            ftpClient.login(username, password);

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();

            String remoteFile = filename;
            File downloadFile = new File(filename);
            OutputStream outputStream = new FileOutputStream(downloadFile);
            boolean success = ftpClient.retrieveFile(remoteFile, outputStream);
            outputStream.close();

            if (success) {
                System.out.println("File downloaded successfully.");
            } else {
                System.out.println("File download failed.");
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


    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java Task77 <hostname> <username> <password> <filename>");
            return;
        }
        try {
            downloadFile(args[0], args[1], args[2], args[3]);

            // Test cases (replace with actual test data)
             downloadFile("test.rebex.net", "demo", "password", "readme.txt");
             downloadFile("test.rebex.net", "demo", "password", "pub.key");
//             downloadFile("speedtest.tele2.net", "anonymous", "anonymous", "1MB.zip");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}