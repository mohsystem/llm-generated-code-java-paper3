package Vanilla.gemini;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import org.xbill.DNS.*;
import org.xbill.DNS.Record;

public class Task91 {

    public static void main(String[] args) throws IOException {
        testDNSResolver("google.com", Type.A);
        testDNSResolver("example.com", Type.A);
        testDNSResolver("yahoo.com", Type.A);
        testDNSResolver("microsoft.com", Type.A);
        testDNSResolver("amazon.com", Type.A);
    }

    public static void testDNSResolver(String domain, int type) throws IOException {
        resolveDNS(domain, type);
    }

    public static void resolveDNS(String domain, int type) throws IOException {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress dnsServer = InetAddress.getByName("8.8.8.8");
            int dnsPort = 53;

            Message query = new Message();
            Header header = query.getHeader();
            header.setID((short) (Math.random() * 65536));
            header.setOpcode(Opcode.QUERY);
            //todo cannot find symbol method setRD(boolean)
//            header.setRD(true); // Recursion desired

            Record question = Record.newRecord(Name.fromString(domain + "."), type, DClass.IN);
            query.addRecord(question, Section.QUESTION);

            byte[] queryBytes = query.toWire();

            DatagramPacket queryPacket = new DatagramPacket(queryBytes, queryBytes.length, dnsServer, dnsPort);
            socket.send(queryPacket);

            byte[] responseBytes = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length);
            socket.receive(responsePacket);

            Message response = new Message(responseBytes);

            for (Record record : response.getSectionArray(Section.ANSWER)) {
                if (record.getType() == type) {
                    System.out.println(record);
                }
            }
        }
    }
}