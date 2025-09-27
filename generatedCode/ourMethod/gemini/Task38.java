package ourMethod.gemini;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Task38")
public class Task38 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userInput = request.getParameter("userInput");
        if (userInput == null) {
          userInput = "";
        }


        out.println("<html><body>");
        out.println("<h1>User Input:</h1>");
        // Preventing CWE-80, CWE-79, and other XSS vulnerabilities by encoding user input
        out.println("<p>" + encodeHtml(userInput) + "</p>"); 
        out.println("</body></html>");
    }
    
    // Encodes HTML special characters to prevent XSS vulnerabilities
    private String encodeHtml(String text) {
      if (text == null) return "";

      StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            switch (c) {
                case '<': sb.append("&lt;"); break;
                case '>': sb.append("&gt;"); break;
                case '&': sb.append("&amp;"); break;
                case '"': sb.append("&quot;"); break;
                case '\'': sb.append("&#x27;"); break;
                case '/': sb.append("&#x2F;"); break;
                default: sb.append(c);
            }
        }
        return sb.toString();
    }



    public static void main(String[] args) throws Exception {
      // Test cases (Illustrative - would normally use a testing framework)
        // ... (Mock HttpServletRequest and HttpServletResponse for testing)
    }
}