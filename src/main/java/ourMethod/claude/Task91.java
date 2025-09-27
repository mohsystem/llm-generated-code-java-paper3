package ourMethod.claude;

import java.net.*;
import java.io.*;
import java.nio.ByteBuffer;

public class Task91 {
    private static final int BUFFER_SIZE = 512; // Standard DNS message size
    private static final int DNS_HEADER_LENGTH = 12;
    
    public static void startDNSServer(String ipAddress, int port) {
        try {
            // Create UDP socket bound to specified address and port
            InetAddress addr = InetAddress.getByName(ipAddress);
            DatagramSocket socket = new DatagramSocket(port, addr);
            
            byte[] buffer = new byte[BUFFER_SIZE];
            
            while(true) {
                // Receive DNS request
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                
                // Parse DNS request
                byte[] dnsData = packet.getData();
                ByteBuffer dnsBuffer = ByteBuffer.wrap(dnsData);
                
                // Extract transaction ID from header
                short transactionId = dnsBuffer.getShort(0);
                
                // Create DNS response
                byte[] response = createDNSResponse(transactionId, dnsData);
                
                // Send response back
                InetAddress clientAddr = packet.getAddress();
                int clientPort = packet.getPort();
                DatagramPacket responsePacket = new DatagramPacket(
                    response, response.length, clientAddr, clientPort);
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private static byte[] createDNSResponse(short transactionId, byte[] request) {
        ByteBuffer response = ByteBuffer.allocate(BUFFER_SIZE);
        
        // Add transaction ID
        response.putShort(transactionId);
        
        // Add flags - Standard response with no error
        response.putShort((short)0x8180);
        
        // Add counts
        response.putShort((short)1); // Questions
        response.putShort((short)1); // Answers
        response.putShort((short)0); // Authority RRs  
        response.putShort((short)0); // Additional RRs
        
        // Copy question from request
        int questionLength = getQuestionLength(request);
        response.put(request, DNS_HEADER_LENGTH, questionLength);
        
        // Add answer section with IP address
        byte[] ip = new byte[]{8, 8, 8, 8}; // Example IP
        response.put(createDNSAnswer(ip));
        
        return response.array();
    }
    
    private static int getQuestionLength(byte[] request) {
        int pos = DNS_HEADER_LENGTH;
        while(request[pos] != 0) {
            pos += request[pos] + 1;
        }
        return pos - DNS_HEADER_LENGTH + 5; // Include null byte and QTYPE/QCLASS
    }
    
    private static byte[] createDNSAnswer(byte[] ip) {
        ByteBuffer answer = ByteBuffer.allocate(16);
        
        answer.putShort((short)0xC00C); // Pointer to question
        answer.putShort((short)1); // Type A record
        answer.putShort((short)1); // Class IN
        answer.putInt(300); // TTL 5 minutes
        answer.putShort((short)4); // RDLENGTH for IPv4
        answer.put(ip); // RDATA - IP address
        
        return answer.array();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testIPs = {
            "127.0.0.1",
            "0.0.0.0", 
            "192.168.1.1",
            "10.0.0.1",
            "172.16.0.1"
        };
        
        int[] testPorts = {53, 5353, 1053, 8053, 9053};
        
        for(int i = 0; i < 5; i++) {
            System.out.println("Test case " + (i+1) + ":");
            System.out.println("Starting DNS server on " + testIPs[i] + ":" + testPorts[i]);
            startDNSServer(testIPs[i], testPorts[i]);
        }
    }
}
