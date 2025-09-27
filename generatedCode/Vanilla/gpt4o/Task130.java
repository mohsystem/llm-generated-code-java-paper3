package Vanilla.gpt4o;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Task130 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.getWriter().write("CORS enabled response");
    }

    public static void main(String[] args) throws Exception {
        // Simulate server setup and request handling
        // Test cases
        Task130 servlet = new Task130();
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        servlet.doGet(request, response);
        System.out.println(response.getContentAsString()); // Test case 1

        servlet.doGet(request, response);
        System.out.println(response.getContentAsString()); // Test case 2

        servlet.doGet(request, response);
        System.out.println(response.getContentAsString()); // Test case 3

        servlet.doGet(request, response);
        System.out.println(response.getContentAsString()); // Test case 4

        servlet.doGet(request, response);
        System.out.println(response.getContentAsString()); // Test case 5
    }
}

// Mock classes to simulate HttpServletRequest and HttpServletResponse
class MockHttpServletRequest extends HttpServletRequestWrapper {
    public MockHttpServletRequest() {
        super(new HttpServletRequestAdapter());
    }
}

class MockHttpServletResponse extends HttpServletResponseWrapper {
    private StringBuilder content = new StringBuilder();

    public MockHttpServletResponse() {
        super(new HttpServletResponseAdapter());
    }

    @Override
    public ServletOutputStream getOutputStream() {
        return new ServletOutputStreamAdapter(content);
    }

    @Override
    public PrintWriter getWriter() {
        return new PrintWriter(new OutputStreamWriter(getOutputStream()));
    }

    public String getContentAsString() {
        return content.toString();
    }
}

// Adapters to avoid using actual server classes
class HttpServletRequestAdapter extends HttpServletRequest {
    // Implement required methods as needed
}

class HttpServletResponseAdapter extends HttpServletResponse {
    // Implement required methods as needed
}

class ServletOutputStreamAdapter extends ServletOutputStream {
    private StringBuilder content;

    public ServletOutputStreamAdapter(StringBuilder content) {
        this.content = content;
    }

    @Override
    public void write(int b) {
        content.append((char) b);
    }
}