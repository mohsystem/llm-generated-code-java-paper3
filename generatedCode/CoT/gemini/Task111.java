package CoT.gemini;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class Task111 {

    public static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }
    }


    public static void main(String[] args) throws IOException {
        int port = 8080; // Default port, can be changed

        WebServer webServer = new WebServer(port);
        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        try {
            phm.addHandler("calculator", Calculator.class);
        } catch (Exception e) {
            System.err.println("Error registering handler: " + e.getMessage());
            System.exit(1);
        }

        xmlRpcServer.setHandlerMapping(phm);

        XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
        serverConfig.setEnabledForExtensions(true);
        serverConfig.setContentLengthOptional(false);

        webServer.start();

        System.out.println("XML-RPC server started on port " + port);


        // Test Cases (client-side code would typically handle this)
        // You'd typically use an XML-RPC client library to make these calls.
        // The below is just illustrative and not executable directly within this server code.

        // Test case 1: calculator.add(5, 7)  Expected: 12
        // Test case 2: calculator.subtract(10, 4) Expected: 6
        // Test case 3: calculator.add(0, 0) Expected: 0
        // Test case 4: calculator.subtract(-5, -3) Expected: -2
        // Test case 5: calculator.add(100, 250) Expected 350

    }
}