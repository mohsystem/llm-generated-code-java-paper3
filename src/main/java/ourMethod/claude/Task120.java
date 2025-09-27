package ourMethod.claude;

// Task120.java
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.commons.lang3.StringEscapeUtils;
//import org.apache.commons.text.StringEscapeUtils;

@WebServlet("/Task120")
public class Task120 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String userInput = request.getParameter("input");
        
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("X-Content-Type-Options", "nosniff");
        response.setHeader("X-Frame-Options", "DENY");
        
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\\n")
            .append("<html>\\n")
            .append("<head>\\n")
            .append("<title>Display Input</title>\\n")
            .append("</head>\\n")
            .append("<body>\\n");

        if (userInput != null) {
            // Escape HTML special characters to prevent XSS
            String escapedInput = StringEscapeUtils.escapeHtml4(userInput);
            html.append("<p>You entered: ").append(escapedInput).append("</p>\\n");
        }

        html.append("<form method='get'>\\n")
            .append("<input type='text' name='input' maxlength='100'>\\n")
            .append("<input type='submit' value='Submit'>\\n")
            .append("</form>\\n")
            .append("</body>\\n")
            .append("</html>");

        response.getWriter().write(html.toString());
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "Hello World",
            "<script>alert('xss')</script>", 
            "Test & <> \"'",
            "Normal text 123",
            "" // Empty input
        };
        
        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Escaped: " + StringEscapeUtils.escapeHtml4(test));
            System.out.println();
        }
    }
}
