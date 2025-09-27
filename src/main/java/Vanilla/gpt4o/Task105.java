package Vanilla.gpt4o;
import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class Task105 {
    public static boolean connectSSL(String host, int port) {
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
            socket.startHandshake();
            socket.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(connectSSL("www.google.com", 443)); // Test case 1
        System.out.println(connectSSL("www.example.com", 443)); // Test case 2
        System.out.println(connectSSL("www.invalid-url.com", 443)); // Test case 3
        System.out.println(connectSSL("www.github.com", 443)); // Test case 4
        System.out.println(connectSSL("www.facebook.com", 443)); // Test case 5
    }
}