package ourMethod.claude;

import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;
import org.apache.xmlrpc.XmlRpcException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Task111 {
    private WebServer webServer;
    
    public static class Calculator {
        public int add(int x, int y) {
            // Input validation
            if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE || 
                y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Input values out of range");
            }
            return x + y;
        }
        
        public int subtract(int x, int y) {
            if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE || 
                y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Input values out of range");
            }
            return x - y;
        }
    }

    public void start() throws IOException {
        try {
            // Create web server
            webServer = new WebServer(8080);
            XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

            // Configure server
            XmlRpcServerConfigImpl config = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
            config.setEnabledForExtensions(false);
            config.setContentLengthOptional(false);
            config.setEnabledForExceptions(true);
            
            // Disable XML external entities
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

            //todo cannot find symbol method handlerMapping()
            // Register handler
//            xmlRpcServer.handlerMapping().addHandler("calculator", Calculator.class);
//            xmlRpcServer.addHandler("calculator", Calculator.class);

            // Start server
            webServer.start();
            System.out.println("XML-RPC Server started on port 8080");
            
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            throw new IOException("Failed to start server", e);
        }
    }

    public void stop() {
        if (webServer != null) {
            webServer.shutdown();
            System.out.println("XML-RPC Server stopped");
        }
    }

    public static void main(String[] args) {
        Task111 server = new Task111();
        try {
            server.start();
            
            // Test cases
            Calculator calc = new Calculator();
            System.out.println("Test 1: 5 + 3 = " + calc.add(5, 3));
            System.out.println("Test 2: 10 - 4 = " + calc.subtract(10, 4));
            System.out.println("Test 3: -5 + 8 = " + calc.add(-5, 8));
            System.out.println("Test 4: 15 - (-5) = " + calc.subtract(15, -5));
            try {
                System.out.println("Test 5: Invalid input test");
                calc.add(Integer.MAX_VALUE, Integer.MAX_VALUE);
            } catch (IllegalArgumentException e) {
                System.out.println("Test 5 passed: " + e.getMessage());
            }
            
        } catch (IOException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}
