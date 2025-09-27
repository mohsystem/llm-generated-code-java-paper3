package ourMethod.gpt4o;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class Task91 {
    private static final int BUFFER_SIZE = 512;

    public static void listenAndServe(String ipAddress, int port) {
        try (DatagramSocket socket = new DatagramSocket(port, InetAddress.getByName(ipAddress))) {
            byte[] buffer = new byte[BUFFER_SIZE];

            while (true) {
                DatagramPacket requestPacket = new DatagramPacket(buffer, BUFFER_SIZE);
                socket.receive(requestPacket);

                InetAddress clientAddress = requestPacket.getAddress();
                int clientPort = requestPacket.getPort();
                byte[] requestData = Arrays.copyOf(requestPacket.getData(), requestPacket.getLength());

                // Parse DNS request
                byte[] responseData = resolveDns(requestData);

                // Send DNS response
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] resolveDns(byte[] requestData) {
        // Dummy implementation, returns the same data
        return requestData;
    }

    public static void main(String[] args) {
        // Test cases
        listenAndServe("127.0.0.1", 5353);
    }
}