package CoT.claude;

import java.net.*;
import java.io.*;
import java.util.*;

public class Task91 {
    private static final int BUFFER_SIZE = 512;
    private DatagramSocket socket;
    private byte[] buffer;
    private Map<String, String> dnsRecords;

    public Task91(String ipAddress, int port) throws SocketException {
        socket = new DatagramSocket(port, InetAddress.getByName(ipAddress));
        buffer = new byte[BUFFER_SIZE];
        dnsRecords = new HashMap<>();
        // Initialize some DNS records
        dnsRecords.put("example.com", "192.168.1.1");
        dnsRecords.put("test.com", "192.168.1.2");
    }

    public void startServer() {
        try {
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);

                // Parse DNS request
                String request = new String(receivePacket.getData(), 0, receivePacket.getLength());
                String response = resolveDNS(request.trim());

                // Send response
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, 
                    clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }

    private String resolveDNS(String domain) {
        return dnsRecords.getOrDefault(domain, "Not found");
    }

    public static void main(String[] args) {
        try {
            Task91 server = new Task91("127.0.0.1", 53);
            server.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
