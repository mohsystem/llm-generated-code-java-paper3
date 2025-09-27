package Vanilla.gpt4o;
// Java code for XML-RPC server
//import org.apache.xmlrpc.WebServer;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class Task111 {
    public Integer add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        try {
            WebServer server = new WebServer(8080);
            XmlRpcServer xmlRpcServer = server.getXmlRpcServer();

            PropertyHandlerMapping phm = new PropertyHandlerMapping();
            phm.addHandler("Task111", Task111.class);
            xmlRpcServer.setHandlerMapping(phm);

            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
            serverConfig.setEnabledForExtensions(true);
            serverConfig.setContentLengthOptional(false);

            server.start();
            System.out.println("Server started successfully.");
        } catch (Exception e) {
            System.err.println("XML-RPC Server Error: " + e.getMessage());
        }
    }
}