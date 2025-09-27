package Vanilla.codestral;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class Task111 {
    public static class MyHandler {
        public String handleRequest(String input) {
            // Process input and generate output
            return "Response: " + input;
        }
    }

    public static void main(String[] args) throws XmlRpcException, IOException {
        WebServer server = new WebServer(8080);
        XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        phm.addHandler("Task111", MyHandler.class);
        xmlRpcServer.setHandlerMapping(phm);
        server.start();
    }
}