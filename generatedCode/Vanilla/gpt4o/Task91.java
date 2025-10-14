package Vanilla.openai;
// Java code to create a UDP socket for DNS requests
import java.net.*;

public class Task91 {
    public static void listenOnUDPSocket(String ipAddress, int port) throws Exception {
        DatagramSocket socket = new DatagramSocket(port, InetAddress.getByName(ipAddress));
        byte[] buffer = new byte[512];

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            // Parse the DNS request
            String dnsRequest = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received DNS request: " + dnsRequest);

            // Resolve DNS records (stub response for demonstration)
            String dnsResponse = "Resolved IP: 127.0.0.1";

            // Send response back
            DatagramPacket responsePacket = new DatagramPacket(dnsResponse.getBytes(), dnsResponse.length(),
                    packet.getAddress(), packet.getPort());
            socket.send(responsePacket);
        }
    }

    public static void main(String[] args) throws Exception {
        // Test cases
        listenOnUDPSocket("127.0.0.1", 5353);
    }
}