package CoT.gpt4o;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class Task91 {
    private static final Map<String, String> dnsRecords = new HashMap<>();

    static {
        dnsRecords.put("example.com", "93.184.216.34");
        dnsRecords.put("google.com", "142.250.190.14");
        dnsRecords.put("localhost", "127.0.0.1");
    }

    public static void main(String[] args) throws Exception {
        listenAndServeDNS("127.0.0.1", 5353);
    }

    public static void listenAndServeDNS(String ip, int port) throws Exception {
        DatagramSocket socket = new DatagramSocket(port, InetAddress.getByName(ip));
        byte[] buffer = new byte[512];

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String domain = new String(packet.getData(), 0, packet.getLength());
            String resolvedIP = dnsRecords.getOrDefault(domain, "0.0.0.0");

            byte[] response = resolvedIP.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(response, response.length, packet.getAddress(), packet.getPort());
            socket.send(responsePacket);
        }
    }
}