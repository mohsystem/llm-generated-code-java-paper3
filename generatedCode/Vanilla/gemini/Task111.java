package Vanilla.gemini;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class Task111 {

    public static class Operations {
        public int add(int a, int b) {
            return a + b;
        }

        public String greet(String name) {
            return "Hello, " + name + "!";
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 8080;
        WebServer webServer = new WebServer(port);
        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        try {
            phm.addHandler("ops", Operations.class);
            xmlRpcServer.setHandlerMapping(phm);

            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
            serverConfig.setEnabledForExtensions(true);
            serverConfig.setContentLengthOptional(false);

            webServer.start();
            System.out.println("XML-RPC server started on port " + port);

            // Test Cases (Client-side code would typically handle these)
            // These are just demonstrations, real testing would use a proper client.

            // Test 1: add(5, 7)
            // Expected: 12

            // Test 2: greet("World")
            // Expected: "Hello, World!"

            // Test 3: add(-3, 10)
            // Expected: 7

            // Test 4: greet("XML-RPC")
            // Expected: "Hello, XML-RPC!"

            // Test 5: add(0, 0)
            // Expected: 0



        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}