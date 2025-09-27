package CoT.llama31;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class Task121 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>File Upload Example</h1>");

        // Get the uploaded file
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();

        // Save the file
        String uploadPath = "C:\\uploads"; // Change this to your desired upload directory
        filePart.write(uploadPath + "\\" + fileName);

        out.println("File uploaded successfully: " + fileName);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><form method='post' enctype='multipart/form-data'>");
        out.println("<input type='file' name='file'><br><br>");
        out.println("<input type='submit' value='Upload File'>");
        out.println("</form></body></html>");
    }
}