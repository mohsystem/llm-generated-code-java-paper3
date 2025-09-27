package ourMethod.gemini;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class Task91 {

    public static void dnsServer(String ipAddress, int port) throws UnknownHostException {
        try (DatagramSocket socket = new DatagramSocket(port, InetAddress.getByName(ipAddress))) {
            System.out.println("DNS Server started on " + ipAddress + ":" + port);

            while (true) {
                byte[] buffer = new byte[512];
                DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);

                try {
                    socket.receive(requestPacket);
                    System.out.println("Received request from: " + requestPacket.getAddress().getHostAddress() + ":" + requestPacket.getPort());


                    ByteBuffer requestData = ByteBuffer.wrap(requestPacket.getData());

                    int transactionId = requestData.getShort();


                    String domain = parseDomainName(requestData);
                    System.out.println("Requested domain: " + domain);


                    InetAddress resolvedIp = InetAddress.getByName(domain);
                    System.out.println("Resolved IP: " + resolvedIp.getHostAddress());


                    ByteBuffer responseData = ByteBuffer.allocate(512);
                    responseData.putShort((short) transactionId);

                    responseData.putShort((short) 0x8180);

                    responseData.putShort((short) 1);
                    responseData.putShort((short) 1);
                    responseData.putShort((short) 0);
                    responseData.putShort((short) 0);

                    responseData.putShort((short) 0xc00c);
                    responseData.putShort((short) 0x0001);
                    responseData.putShort((short) 0x0001);
                    responseData.putInt(0);
                    responseData.putShort((short) 4);
                    responseData.put(resolvedIp.getAddress());

                    byte[] responseBuffer = responseData.array();

                    DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length, requestPacket.getAddress(), requestPacket.getPort());
                    socket.send(responsePacket);
                    System.out.println("Sent response to: " + responsePacket.getAddress().getHostAddress() + ":" + responsePacket.getPort());

                } catch (IOException e) {
                    System.err.println("Error handling request: " + e.getMessage());
                }
            }
        } catch (SocketException e) {
            System.err.println("Error creating socket: " + e.getMessage());
        }
    }



    private static String parseDomainName(ByteBuffer data) {
        StringBuilder domain = new StringBuilder();
        int len = data.get();
        while (len != 0) {
            for (int i = 0; i < len; i++) {
                domain.append((char) data.get());
            }
            domain.append('.');
            len = data.get();
        }

        if (domain.length() > 0) {
            domain.deleteCharAt(domain.length() - 1);
        }
        return domain.toString();
    }

    public static void main(String[] args) throws UnknownHostException {

        dnsServer("127.0.0.1", 5353);

    }
}