package Vanilla.codestral;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.PrintWriter;

public class Task105 {
    public static void main(String[] args) throws IOException {
        connectToServer("example.com", 443);
    }

    public static void connectToServer(String host, int port) throws IOException {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
        socket.startHandshake();

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("GET / HTTP/1.0");
        out.println("Host: " + host);
        out.println("Connection: close");
        out.println();

        socket.close();
    }
}