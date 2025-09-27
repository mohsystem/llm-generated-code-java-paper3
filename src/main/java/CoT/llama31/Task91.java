package CoT.llama31;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Task91 {
    public static void main(String[] args) {
        int port = 8053; // Specify the port to listen on
        try (DatagramSocket socket = new DatagramSocket(port)) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while (true) {
                socket.receive(packet);
                String request = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + request);
                // Simulate resolving DNS records (this is a very simplified example)
                String response = "DNS Response";
                byte[] responseData = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, packet.getAddress(), packet.getPort());
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}