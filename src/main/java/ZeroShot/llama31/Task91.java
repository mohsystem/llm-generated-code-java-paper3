package ZeroShot.llama31;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Task91 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(53); // DNS port
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                // Parse the DNS request
                byte[] data = packet.getData();
                int length = packet.getLength();
                String request = new String(data, 0, length);

                // Simulate DNS resolution (in real scenario, you would query a DNS server)
                String response = "DNS response for " + request;

                // Send the response back
                byte[] responseData = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, packet.getAddress(), packet.getPort());
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}