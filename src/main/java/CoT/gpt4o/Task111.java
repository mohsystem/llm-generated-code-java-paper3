package CoT.gpt4o;
//import org.apache.xmlrpc.WebServer;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

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
            System.out.println("XML-RPC server is running...");
        } catch (XmlRpcException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}