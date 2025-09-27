package CoT.llama31;
//import org.apache.xmlrpc.WebServer;
//import org.apache.xmlrpc.XmlRpc;
import org.apache.xmlrpc.XmlRpcConfig;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfig;
import org.apache.xmlrpc.webserver.WebServer;

public class Task111 {
    public static void main(String[] args) {
        try {
            System.out.println("Attempting to start XML-RPC Server...");
            WebServer server = new WebServer(80);
            PropertyHandlerMapping phm = new PropertyHandlerMapping();
            phm.addHandler("Task111", Task111.class);
            XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
            xmlRpcServer.setHandlerMapping(phm);
            XmlRpcServerConfig config = (XmlRpcServerConfig) xmlRpcServer.getConfig();
            //todo these methods are not working based on the imported package.
//            config.setEnabledForExtensions(true);
//            config.setContentLengthOptional(false);
            server.start();
            System.out.println("Started successfully.");
            System.out.println("Accepting requests. (Halt program to stop.)");
        } catch (Exception exception) {
            System.err.println("JavaServer: " + exception);
        }
    }

    public Integer sum(int x, int y) {
        return x + y;
    }

    public String uppercase(String str) {
        return str.toUpperCase();
    }

    public static void mainTest() {
        Task111 server = new Task111();
        System.out.println(server.sum(10, 20)); // Output: 30
        System.out.println(server.uppercase("hello")); // Output: HELLO
    }
}