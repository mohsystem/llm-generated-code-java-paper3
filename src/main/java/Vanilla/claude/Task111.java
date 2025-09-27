package Vanilla.claude;

// Java does not have a simple built-in XML-RPC server implementation
// Would require external libraries like Apache XML-RPC
// Basic structure would be:

//import org.apache.xmlrpc.WebServer;
import org.apache.xmlrpc.webserver.WebServer;

public class Task111 {
    public void startServer() {
        try {
            WebServer server = new WebServer(8080);
            //todo cannot find symbol method addHandler(String,Task111)
//            server.addHandler("sample", this);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        Task111 server = new Task111();
        server.startServer();
    }
}
