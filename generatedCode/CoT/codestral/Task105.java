package CoT.codestral;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.PrintWriter;

public class Task105 {
    public static void main(String[] args) throws Exception {
        SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("www.example.com", 443);
        PrintWriter out = new PrintWriter(sslsocket.getOutputStream(), true);
        out.println("GET / HTTP/1.0");
        out.println();
        out.flush();
        sslsocket.close();
    }
}