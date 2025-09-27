package CoT.codestral;
// This is a simple example of an XML-RPC server using Apache's XML-RPC library.
// Note: This example does not include security measures. For a production environment,
// additional security measures such as authentication and encryption should be implemented.

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

public class Task111 {
    public static void main(String[] args) throws Exception {
        WebServer webServer = new WebServer(8080);
        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        phm.addHandler("example", Task111.class);

        xmlRpcServer.setHandlerMapping(phm);
        webServer.start();

        System.out.println("Started server on port 8080");
    }

    public String handleRequest(String request) {
        return "Received request: " + request;
    }
}