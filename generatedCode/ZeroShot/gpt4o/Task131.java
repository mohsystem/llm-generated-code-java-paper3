package ZeroShot.gpt4o;
import java.io.*;

public class Task131 {
    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        try (ObjectInput in = new ObjectInputStream(bis)) {
            return in.readObject();
        }
    }

    public static void main(String[] args) {
        try {
            // Test cases
            byte[] data1 = new byte[] {}; // Empty data
            System.out.println(deserialize(data1));

            byte[] data2 = new byte[] {0, 1, 2, 3}; // Random data
            System.out.println(deserialize(data2));

            byte[] data3 = new byte[] {-84, -19, 0, 5, 116, 0, 4, 116, 101, 115, 116}; // Serialized "test"
            System.out.println(deserialize(data3));

            byte[] data4 = new byte[] {-84, -19, 0, 5, 115, 114, 0, 17, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 73, 110, 116, 101, 103, 101, 114, 2, -117, -122, -72, 0, 0, 0, 120, 112, 119, 4, 0, 0, 0, 1}; // Serialized Integer 1
            System.out.println(deserialize(data4));

            byte[] data5 = new byte[] {-84, -19, 0, 5, 116, 0, 5, 72, 101, 108, 108, 111}; // Serialized "Hello"
            System.out.println(deserialize(data5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}