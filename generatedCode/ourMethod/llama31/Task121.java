package ourMethod.llama31;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100) // 100 MB
public class Task121 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uploadPath = "C:\\uploads"; // Ensure this directory exists and is secure
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        try (PrintWriter out = response.getWriter()) {
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();

            // Prevent path traversal attacks
            Path filePath = Paths.get(uploadPath, fileName);
            if (!filePath.normalize().toString().startsWith(uploadPath)) {
                out.println("Invalid file path");
                return;
            }

            try (InputStream fileInputStream = filePart.getInputStream();
                 OutputStream fileOutputStream = Files.newOutputStream(filePath)) {
                fileInputStream.transferTo(fileOutputStream);
                out.println("File uploaded successfully");
            } catch (Exception e) {
                out.println("Error uploading file: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // For testing purposes, you can simulate file upload using HTTP client
        // This is not part of the servlet code but for demonstration
        System.out.println("File upload servlet ready");
    }
}