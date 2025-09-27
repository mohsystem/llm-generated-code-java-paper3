package ZeroShot.gemini;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

class Task91 {

    public static void dnsResolver(String ipAddress, int port) throws IOException {
        try (DatagramSocket serverSocket = new DatagramSocket(port, InetAddress.getByName(ipAddress))) {
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Parse DNS request (Simplified example - extract domain name)
                String domainName = extractDomainName(receivePacket.getData());
                System.out.println("Received request for: " + domainName);


                // Resolve DNS record (Simplified example - mock resolution)
                String resolvedIP = mockResolve(domainName);

                // Construct DNS response (Simplified example)
                sendData = createDNSResponse(resolvedIP);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
                System.out.println("Sent response to: " + clientAddress + ":" + clientPort);
            }
        }
    }


    private static String extractDomainName(byte[] data) {
        // Simplified example. Actual parsing is more complex
        String request = new String(data);
        int start = request.indexOf(" ") + 1;
        int end = request.indexOf(" ", start);

        return request.substring(start,end);
    }

    private static String mockResolve(String domainName) {
        // Replace with actual DNS resolution logic. This is a placeholder.
        if (domainName.equals("example.com")) {
            return "192.168.1.100"; // Example resolved IP
        } else {
            return "0.0.0.0"; // Example for unknown domain
        }
    }

    private static byte[] createDNSResponse(String resolvedIP) {
         // Simplified example. Actual response formatting is more complex
        return ("IP: " + resolvedIP).getBytes();
    }


    public static void main(String[] args) {
        try {
            dnsResolver("127.0.0.1", 9876);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}