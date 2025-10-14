package ZeroShot.openai;
import org.apache.xmlrpc.WebServer;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.XmlRpcHandler;
import org.apache.xmlrpc.XmlRpcServer;

public class Task111 {
    public static class XmlRpcServerHandler {
        public String sayHello(String name) {
            return "Hello, " + name;
        }
    }

    public static void main(String[] args) {
        try {
            WebServer server = new WebServer(8080);
            XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
            xmlRpcServer.setHandlerMapping((request) -> {
                if (request.getMethodName().equals("XmlRpcServerHandler.sayHello")) {
                    return new XmlRpcServerHandler();
                }
                throw new XmlRpcException("Unknown method: " + request.getMethodName());
            });
            server.start();
            System.out.println("Server started successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}