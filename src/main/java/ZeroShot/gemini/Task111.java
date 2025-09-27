package ZeroShot.gemini;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class Task111 {

    public static class Methods {
        public String greet(String name) {
            return "Hello, " + name + "!";
        }

        public int add(int a, int b) {
            return a + b;
        }
    }

    public static void main(String[] args) throws IOException, XmlRpcException {
        WebServer webServer = new WebServer(8080);
        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        //todo Unhandled exception: org.apache.xmlrpc.XmlRpcException
        phm.addHandler("methods", Methods.class); 
        xmlRpcServer.setHandlerMapping(phm);

        XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
        serverConfig.setEnabledForExtensions(true);
        serverConfig.setContentLengthOptional(false);

        webServer.start();

        System.out.println("XML-RPC server started on port 8080.");


        // Test Cases (Client-side code would typically perform these)
        // Note: This demonstrates making calls as if from a client, but within the same program.
        // In real usage, a separate client application would be used.

        try {
            org.apache.xmlrpc.client.XmlRpcClientConfigImpl config = new org.apache.xmlrpc.client.XmlRpcClientConfigImpl();
            config.setServerURL(new java.net.URL("http://127.0.0.1:8080/"));
            org.apache.xmlrpc.client.XmlRpcClient client = new org.apache.xmlrpc.client.XmlRpcClient();
            client.setConfig(config);

            Object[] params1 = new Object[]{"XML-RPC"};
            String result1 = (String) client.execute("methods.greet", params1);
            System.out.println("Test 1: " + result1); // Expected: Hello, XML-RPC!

            Object[] params2 = new Object[]{5, 7};
            Integer result2 = (Integer) client.execute("methods.add", params2);
            System.out.println("Test 2: " + result2); // Expected: 12

            Object[] params3 = new Object[]{"World"};
            String result3 = (String) client.execute("methods.greet", params3);
            System.out.println("Test 3: " + result3); // Expected: Hello, World!

            Object[] params4 = new Object[]{10, -3};
            Integer result4 = (Integer) client.execute("methods.add", params4);
            System.out.println("Test 4: " + result4); // Expected: 7

            Object[] params5 = new Object[]{""};
            String result5 = (String) client.execute("methods.greet", params5);
            System.out.println("Test 5: " + result5); // Expected: Hello, !

        } catch (Exception exception) {
            System.err.println("Java Client: " + exception);
        }



    }
}