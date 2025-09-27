package CoT.gemini;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import org.xbill.DNS.*;
import org.xbill.DNS.Record;

public class Task91 {

    public static void main(String[] args) throws IOException {
        test("google.com", Type.A);
        test("facebook.com", Type.A);
        test("amazon.com", Type.A);
        test("wikipedia.org", Type.A);
        test("example.com", Type.AAAA);
    }


    public static void test(String domain, int type) throws IOException {
        dnsQueryAndResponse(domain, type);
    }


    public static void dnsQueryAndResponse(String domain, int type) throws IOException {
        try (DatagramSocket socket = new DatagramSocket()) {
            // 1. Send DNS Query
            byte[] queryData = createDnsQuery(domain, type);
            DatagramPacket queryPacket = new DatagramPacket(queryData, queryData.length, InetAddress.getByName("8.8.8.8"), 53);
            socket.send(queryPacket);

            // 2. Receive DNS Response
            byte[] responseData = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);
            socket.receive(responsePacket);

            // 3. Parse and Print Response
            parseAndPrintDnsResponse(responsePacket.getData(), domain);

        } catch (UnknownHostException e) {
            System.err.println("Error resolving DNS server address: " + e.getMessage());
        }
    }


    private static byte[] createDnsQuery(String domain, int type) {
//        Record query = Record.createRecord(Name.fromString(domain + "."), type, DClass.IN);
        Record query = null;
        Message queryMessage = Message.newQuery(query);
        return queryMessage.toWire();
    }


    private static void parseAndPrintDnsResponse(byte[] responseData, String domain) {
        try {
            Message responseMessage = new Message(responseData);
            Record[] answers = responseMessage.getSectionArray(Section.ANSWER);

            if (answers.length > 0) {
                System.out.println("DNS Response for " + domain + ":");
                for (Record record : answers) {
                    System.out.println(record);
                }
            } else {
                System.out.println("No DNS records found for " + domain);
            }
        } catch (IOException e) {
            System.err.println("Error parsing DNS response: " + e.getMessage());
        }
    }
}