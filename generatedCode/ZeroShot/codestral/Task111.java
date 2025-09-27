package ZeroShot.codestral;
import java.io.IOException;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

public class Task111 {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        WebServer webServer = new WebServer(8080);
        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        phm.addHandler("Task111", Task111.class);

        xmlRpcServer.setHandlerMapping(phm);
        webServer.start();
    }
}