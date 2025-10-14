package CoT.openai;
import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class Task105 {

    public static void establishSSLConnection(String host, int port) {
        try {
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, null, new java.security.SecureRandom());

            SSLSocketFactory socketFactory = context.getSocketFactory();
            SSLSocket socket = (SSLSocket) socketFactory.createSocket(host, port);

            socket.startHandshake();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            writer.write("GET / HTTP/1.1\r\n");
            writer.write("Host: " + host + "\r\n");
            writer.write("\r\n");
            writer.flush();

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        establishSSLConnection("www.example.com", 443);
        establishSSLConnection("www.google.com", 443);
        establishSSLConnection("www.github.com", 443);
        establishSSLConnection("www.stackoverflow.com", 443);
        establishSSLConnection("www.microsoft.com", 443);
    }
}