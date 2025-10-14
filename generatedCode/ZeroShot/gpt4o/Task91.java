package ZeroShot.openai;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Task91 {
    public static void main(String[] args) {
        try {
            listenDNS("0.0.0.0", 5353);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listenDNS(String ip, int port) throws Exception {
        DatagramSocket socket = new DatagramSocket(port, InetAddress.getByName(ip));
        byte[] buffer = new byte[512];
        
        while (true) {
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            socket.receive(request);

            String query = new String(request.getData(), 0, request.getLength());
            System.out.println("Received DNS query: " + query);
            
            // Simplified DNS response example
            String responseMessage = "Response to: " + query;
            byte[] responseData = responseMessage.getBytes();
            
            DatagramPacket response = new DatagramPacket(responseData, responseData.length, 
                                                         request.getAddress(), request.getPort());
            socket.send(response);
        }
    }
}