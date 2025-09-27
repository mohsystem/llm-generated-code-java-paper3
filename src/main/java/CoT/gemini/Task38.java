package CoT.gemini;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Task38")
public class Task38 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String userInput = request.getParameter("userInput");

        // Escape user input to prevent XSS
        String safeUserInput = escapeHtml(userInput);


        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>User Input Display</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>You entered:</h1>");
        out.println("<p>" + safeUserInput + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
    
    private String escapeHtml(String input) {
        if (input == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '<': sb.append("&lt;"); break;
                case '>': sb.append("&gt;"); break;
                case '&': sb.append("&amp;"); break;
                case '"': sb.append("&quot;"); break;
                case '\'': sb.append("&#x27;"); break;
                case '/': sb.append("&#x2F;"); break; // Prevent closing tags
                default: sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        // Test cases (would typically be run in a web server environment)
        // These are simulated tests
        String[] testInputs = {"Hello, world!", "<script>alert('XSS!')</script>", "Test & Test", "\"", "''''''"};
        for (String input : testInputs) {
            System.out.println("Input: " + input);
            System.out.println("Escaped Output: " + (new Task38()).escapeHtml(input));
            System.out.println();
        }

    }
}