package ourMethod.gpt4o;
//import org.apache.xmlrpc.WebServer;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.server.*;
//import org.apache.xmlrpc.server.XmlRpcHandler;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task111 {
    public static class MyHandler {
        public int sum(int x, int y) {
            return x + y;
        }
    }

    public static void main(String[] args) {
        try {
            WebServer webServer = new WebServer(8080);
            XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

            PropertyHandlerMapping phm = new PropertyHandlerMapping();
            phm.addHandler("MyHandler", MyHandler.class);
            xmlRpcServer.setHandlerMapping(phm);

            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
            serverConfig.setEnabledForExtensions(true);
            serverConfig.setContentLengthOptional(false);

            webServer.start();
            System.out.println("Server started successfully on port 8080.");
        } catch (XmlRpcException | IOException e) {
            e.printStackTrace();
        }
    }
}