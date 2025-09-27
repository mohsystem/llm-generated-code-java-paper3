package Vanilla.llama31;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Task91 {
    public static void main(String[] args) throws Exception {
        // Test cases
        String[] dnsServers = {"8.8.8.8", "8.8.4.4"};
        int port = 53;

        // Create a UDP socket
        DatagramSocket socket = new DatagramSocket(port);

        while (true) {
            // Receive data
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            // Parse and resolve DNS request (simulated)
            String response = resolveDNS(buffer);

            // Send response back
            byte[] responseBytes = response.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, packet.getAddress(), packet.getPort());
            socket.send(responsePacket);
        }
    }

    public static String resolveDNS(byte[] data) {
        // Simulated DNS resolution
        return "DNS response";
    }
}