package Vanilla.claude;

import java.net.*;
import java.io.*;

public class Task91 {
    private static final int BUFFER_SIZE = 512;
    
    public void startDNSServer(String ipAddress, int port) throws IOException {
        DatagramSocket socket = new DatagramSocket(port, InetAddress.getByName(ipAddress));
        byte[] buffer = new byte[BUFFER_SIZE];
        
        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            
            // Parse DNS request
            byte[] data = packet.getData();
            int queryId = ((data[0] & 0xFF) << 8) | (data[1] & 0xFF);
            String domainName = parseDomainName(data);
            
            // Create DNS response
            byte[] response = createDNSResponse(queryId, domainName);
            
            // Send response
            DatagramPacket responsePacket = new DatagramPacket(
                response, 
                response.length,
                packet.getAddress(),
                packet.getPort()
            );
            socket.send(responsePacket);
        }
    }
    
    private String parseDomainName(byte[] data) {
        StringBuilder name = new StringBuilder();
        int position = 12; // Skip DNS header
        
        while (data[position] != 0) {
            int length = data[position] & 0xFF;
            position++;
            
            for (int i = 0; i < length; i++) {
                name.append((char) (data[position + i] & 0xFF));
            }
            name.append('.');
            position += length;
        }
        
        return name.substring(0, name.length() - 1);
    }
    
    private byte[] createDNSResponse(int queryId, String domain) {
        try {
            InetAddress resolvedIP = InetAddress.getByName(domain);
            byte[] ip = resolvedIP.getAddress();
            
            byte[] response = new byte[32];
            // DNS Header
            response[0] = (byte) ((queryId >> 8) & 0xFF);
            response[1] = (byte) (queryId & 0xFF);
            response[2] = (byte) 0x81; // Response + Recursion
            response[3] = (byte) 0x80;
            response[6] = 0x00; // 1 answer
            response[7] = 0x01;
            
            // Copy question from request
            System.arraycopy(new byte[]{0xC0, 0x0C}, 0, response, 12, 2);
            
            // Answer
            response[14] = 0x00;
            response[15] = 0x01; // Type A
            response[16] = 0x00;
            response[17] = 0x01; // Class IN
            response[21] = 0x00; // TTL
            response[22] = 0x04; // Data length
            
            // Copy IP address
            System.arraycopy(ip, 0, response, 23, 4);
            
            return response;
        } catch (UnknownHostException e) {
            return new byte[0];
        }
    }

    public static void main(String[] args) {
        Task91 server = new Task91();
        try {
            // Test case 1: Start server on localhost:53
            server.startDNSServer("127.0.0.1", 53);
            
            // Note: Real testing would require sending actual DNS queries
            // Test cases 2-5 would involve sending different domain queries
            // Example domains: google.com, example.com, localhost, etc.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
