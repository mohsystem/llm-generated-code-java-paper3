package ourMethodv2.gpt4o;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Task91 {

    private DatagramSocket socket;
    private byte[] buffer = new byte[512];

    public Task91(String ipAddress, int port) throws SocketException {
        socket = new DatagramSocket(port, InetAddress.getByName(ipAddress));
    }

    public void listen() {
        try {
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                byte[] receivedData = packet.getData();
                
                // DNS request parsing logic here
                byte[] responseData = resolveDNS(receivedData);

                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, address, port);
                socket.send(responsePacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] resolveDNS(byte[] requestData) {
        // Basic DNS resolution simulation
        return requestData;
    }

    public static void main(String[] args) throws SocketException {
        Task91 server = new Task91("127.0.0.1", 5353);
        server.listen();
    }
}