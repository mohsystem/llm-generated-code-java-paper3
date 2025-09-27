package CoT.codestral;
// Task131.java
import java.io.*;

public class Task131 {
    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Assuming 'serializedData' is a byte array containing the serialized data
            byte[] serializedData = ...;
            Object deserializedObj = deserialize(serializedData);
            System.out.println(deserializedObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}