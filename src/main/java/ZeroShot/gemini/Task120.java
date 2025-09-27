package ZeroShot.gemini;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Task120 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String userInput = request.getParameter("userInput");

            // Escape user input to prevent XSS vulnerabilities
            String safeUserInput = escapeHtml(userInput);


            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Input Display</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>User Input:</h1>");
            out.println("<p>" + safeUserInput + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
     private String escapeHtml(String input) {
        if (input == null) {
            return "";
        }

        StringBuilder safeInput = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '<':
                    safeInput.append("&lt;");
                    break;
                case '>':
                    safeInput.append("&gt;");
                    break;
                case '&':
                    safeInput.append("&amp;");
                    break;
                case '"':
                    safeInput.append("&quot;");
                    break;
                case '\'':
                    safeInput.append("&#x27;");
                    break;
                case '/':
                    safeInput.append("&#x2F;");
                    break;
                default:
                    safeInput.append(c);
            }
        }
        return safeInput.toString();
    }


    // Test cases (for demonstration - would typically be handled by a testing framework)
    public static void main(String[] args) {
        Task120 task = new Task120();
        String[] testCases = {
                "<script>alert('XSS')</script>",
                "<b>bold text</b>",
                "plain text",
                "1 < 2 > 3",
                null
        };
        for (String testCase : testCases) {
            System.out.println("Input: " + testCase);
            System.out.println("Escaped Output: " + task.escapeHtml(testCase));
            System.out.println("---");

        }
    }

}