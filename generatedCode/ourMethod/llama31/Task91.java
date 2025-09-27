package ourMethod.llama31;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Task91 {
    public static void main(String[] args) throws Exception {
        // Specify IP and port
        String ipAddress = "127.0.0.1";
        int port = 53;

        // Create a UDP socket
        DatagramSocket socket = new DatagramSocket(port, InetAddress.getByName(ipAddress));

        // Buffer to receive data
        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

        while (true) {
            // Receive data
            socket.receive(receivePacket);

            // Parse DNS request
            byte[] data = receivePacket.getData();
            String domain = parseDNSRequest(data);

            if (domain != null) {
                // Resolve DNS record (for simplicity, assume a hardcoded response)
                String ip = resolveDNS(domain);

                if (ip != null) {
                    // Create DNS response
                    byte[] response = createDNSResponse(domain, ip);

                    // Send response back
                    DatagramPacket sendPacket = new DatagramPacket(response, response.length, receivePacket.getAddress(), receivePacket.getPort());
                    socket.send(sendPacket);
                }
            }
        }
    }

    private static String parseDNSRequest(byte[] data) {
        // Simplified parsing, in real scenarios use a DNS library
        String domain = new String(data, 12, data.length - 12);
        return domain;
    }

    private static String resolveDNS(String domain) {
        // For simplicity, assume a hardcoded response
        return "192.168.1.1";
    }

    private static byte[] createDNSResponse(String domain, String ip) {
        // Simplified response creation, in real scenarios use a DNS library
        byte[] response = new byte[12 + domain.length() + ip.length()];
        System.arraycopy("Hello".getBytes(), 0, response, 0, 5);
        System.arraycopy(domain.getBytes(), 0, response, 5, domain.length());
        System.arraycopy(ip.getBytes(), 0, response, 5 + domain.length(), ip.length());
        return response;
    }
}