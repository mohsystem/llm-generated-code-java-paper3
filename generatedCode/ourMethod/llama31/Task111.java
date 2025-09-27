package ourMethod.llama31;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.server.XmlRpcServerImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class Task111 {
    public static void main(String[] args) throws Exception {
        // Create an instance of the XML-RPC server
        WebServer webServer = new WebServer(8080);

        // Create an instance of the server
        XmlRpcServer xmlRpcServer = new XmlRpcServerImpl();
        xmlRpcServer.setConfig(new XmlRpcServerConfigImpl());

        // Register a handler for the server
        xmlRpcServer.getHandlerMapping().registerHandler("sample", new SampleHandler());

        // Set the server instance to the web server
        webServer.getXmlRpcServer().setServer(xmlRpcServer);

        // Start the web server
        webServer.start();

        System.out.println("XML-RPC server started on port 8080");
    }
}

class SampleHandler {
    public int sum(int x, int y) {
        return x + y;
    }

    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}