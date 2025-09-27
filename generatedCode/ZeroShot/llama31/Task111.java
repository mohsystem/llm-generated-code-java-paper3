package ZeroShot.llama31;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class Task111 {
    public static void main(String[] args) throws Exception {
        WebServer webServer = new WebServer(8080);
        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        phm.addHandler("Task111", Task111.class);
        xmlRpcServer.setHandlerMapping(phm);

        XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
        serverConfig.setEnabledForExtensions(true);
        serverConfig.setContentLengthOptional(false);

        webServer.start();
        System.out.println("XML-RPC server started on port 8080");
    }

    public String handleRequest(String methodName, Object[] params) {
        if (methodName.equals("examples.getStateName")) {
            return "State Name: " + params[0];
        }
        return "Method not found";
    }
}