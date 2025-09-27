package ourMethod.gemini;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class Task111 {

    public static class Operations {
        public int add(int x, int y) {
            return x + y;
        }

        public String concat(String s1, String s2) {
            return s1 + s2;
        }
    }


    public static void main(String[] args) throws IOException {
        int port = 8080; 

        WebServer webServer = new WebServer(port);
        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

        PropertyHandlerMapping phm = new PropertyHandlerMapping();

        try {
            phm.addHandler("operations", Task111.Operations.class);
            xmlRpcServer.setHandlerMapping(phm);


            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
            serverConfig.setEnabledForExtensions(true);
            serverConfig.setContentLengthOptional(false);


            webServer.start();
            System.out.println("XML-RPC server started on port " + port);

            // Test cases (client-side code would typically handle these)
            testAdd(5, 7, 12);
            testAdd(-3, 10, 7);
            testConcat("Hello", " World", "Hello World");
            testConcat("", "Test", "Test");
            testConcat("Java", "XML-RPC", "JavaXML-RPC");


        } catch (XmlRpcException e) {
            System.err.println("XmlRpcException: " + e.getMessage());
        }

    }

    private static void testAdd(int x, int y, int expected) {
        // Simulate a client call
        Operations ops = new Operations();
        int result = ops.add(x, y);
        assert result == expected : "Add test failed: " + x + " + " + y + " != " + expected;
    }

    private static void testConcat(String s1, String s2, String expected) {
        // Simulate a client call
        Operations ops = new Operations();
        String result = ops.concat(s1, s2);
        assert result.equals(expected) : "Concat test failed: " + s1 + " + " + s2 + " != " + expected;
    }
}