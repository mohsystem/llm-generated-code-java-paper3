package Vanilla.claude;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Task80 {
    public static SSLSocket createSSLSocket(String host, int port) throws Exception {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
        socket.setEnabledProtocols(new String[] {"TLSv1.2"});
        return socket;
    }

    public static void main(String[] args) {
        try {
            // Test case 1
            SSLSocket socket1 = createSSLSocket("google.com", 443);
            System.out.println("Test 1: Connected to google.com:443");
            socket1.close();

            // Test case 2 
            SSLSocket socket2 = createSSLSocket("github.com", 443);
            System.out.println("Test 2: Connected to github.com:443");
            socket2.close();

            // Test case 3
            SSLSocket socket3 = createSSLSocket("microsoft.com", 443);
            System.out.println("Test 3: Connected to microsoft.com:443");
            socket3.close();

            // Test case 4
            SSLSocket socket4 = createSSLSocket("amazon.com", 443);
            System.out.println("Test 4: Connected to amazon.com:443");
            socket4.close();

            // Test case 5
            SSLSocket socket5 = createSSLSocket("facebook.com", 443);
            System.out.println("Test 5: Connected to facebook.com:443");
            socket5.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
