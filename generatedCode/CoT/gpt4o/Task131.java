package CoT.openai;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Task131 {
    public static Object deserialize(byte[] data) {
        if (data == null || data.length == 0) return null;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        byte[] testData1 = {};  // Empty input
        byte[] testData2 = null;  // Null input
        byte[] testData3 = new byte[]{0x0};  // Minimal data input
        byte[] testData4 = new byte[]{(byte)0xAC, (byte)0xED, 0x00, 0x05};  // Invalid serialized data
        byte[] testData5 = new byte[]{(byte)0xAC, (byte)0xED, 0x00, 0x05};  // Invalid serialized data

        System.out.println(deserialize(testData1));
        System.out.println(deserialize(testData2));
        System.out.println(deserialize(testData3));
        System.out.println(deserialize(testData4));
        System.out.println(deserialize(testData5));
    }
}