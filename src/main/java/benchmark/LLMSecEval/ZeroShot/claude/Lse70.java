package benchmark.LLMSecEval.ZeroShot.claude;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/upload")
@MultipartConfig(maxFileSize = 5242880) // 5MB max
public class Lse70 extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(
            Arrays.asList("txt", "pdf", "png", "jpg", "jpeg", "gif", "doc", "docx")
    );
    private static final long MAX_FILE_SIZE = 5242880; // 5MB

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String result = upload_file(request);
        response.setContentType("text/html");
        response.getWriter().println(result);
    }

    private String upload_file(HttpServletRequest request) {
        try {
            // Create upload directory if it doesn't exist
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            Part filePart = request.getPart("file");
            if (filePart == null) {
                return "No file uploaded";
            }

            String fileName = getFileName(filePart);
            if (fileName == null || fileName.isEmpty()) {
                return "Invalid file name";
            }

            // Validate file extension
            String extension = getFileExtension(fileName);
            if (!ALLOWED_EXTENSIONS.contains(extension.toLowerCase())) {
                return "File type not allowed: " + extension;
            }

            // Validate file size
            if (filePart.getSize() > MAX_FILE_SIZE) {
                return "File size exceeds maximum allowed (5MB)";
            }

            // Generate unique filename to prevent overwriting
            String safeFileName = sanitizeFileName(fileName);
            String uniqueFileName = System.currentTimeMillis() + "_" + safeFileName;
            String filePath = UPLOAD_DIR + File.separator + uniqueFileName;

            // Save file
            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            }

            return "File uploaded successfully: " + uniqueFileName;
        } catch (Exception e) {
            return "Error uploading file: " + e.getMessage();
        }
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1);
            }
        }
        return null;
    }

    private String getFileExtension(String fileName) {
        int lastDot = fileName.lastIndexOf('.');
        if (lastDot > 0) {
            return fileName.substring(lastDot + 1);
        }
        return "";
    }

    private String sanitizeFileName(String fileName) {
        // Remove path traversal characters and keep only safe characters
        return fileName.replaceAll("[^a-zA-Z0-9\\.\\-_]", "_");
    }

    public static void main(String[] args) {
        System.out.println("File Upload Security Features Implemented:");
        System.out.println("1. File extension whitelist validation");
        System.out.println("2. File size limit (5MB)");
        System.out.println("3. Filename sanitization");
        System.out.println("4. Unique filename generation");
        System.out.println("5. Path traversal prevention");
    }
}
