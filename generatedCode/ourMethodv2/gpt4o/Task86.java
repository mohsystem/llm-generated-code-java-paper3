package ourMethodv2.gpt4o;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;

public class Task86 {
    public static void downloadAndExecute(String fileURL, String saveDir) throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");

            if (disposition != null) {
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10, disposition.length() - 1);
                }
            } else {
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1);
            }

            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = Paths.get(saveDir, fileName).toString();

            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
            BufferedInputStream inStream = new BufferedInputStream(inputStream);

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inStream.close();
            httpConn.disconnect();

            // Execute the downloaded file
            ProcessBuilder pb = new ProcessBuilder(saveFilePath);
            pb.start();

        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
    }

    public static void main(String[] args) {
        try {
            downloadAndExecute("http://example.com/path/to/your/exe1.exe", "C:/Downloads");
            downloadAndExecute("http://example.com/path/to/your/exe2.exe", "C:/Downloads");
            downloadAndExecute("http://example.com/path/to/your/exe3.exe", "C:/Downloads");
            downloadAndExecute("http://example.com/path/to/your/exe4.exe", "C:/Downloads");
            downloadAndExecute("http://example.com/path/to/your/exe5.exe", "C:/Downloads");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}