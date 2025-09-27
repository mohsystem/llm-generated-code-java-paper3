package ourMethod.llama31;
import java.io.*;

public class Task131 {
    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "validserializeddata",
            "invalidserializeddata",
            "maliciousserializeddata",
            "empty",
            "null"
        };

        for (String testCase : testCases) {
            try {
                deserialize(testCase);
            } catch (Exception e) {
                System.out.println("Error deserializing: " + e.getMessage());
            }
        }
    }

    public static void deserialize(String data) throws Exception {
        if (data == null || data.isEmpty()) {
            throw new Exception("Invalid input data");
        }

        try (ByteArrayInputStream bis = new ByteArrayInputStream(data.getBytes());
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            //todo resolveClass(ObjectStreamClass) has protected access in ObjectInputStream
            // Use a whitelist to ensure only expected classes are deserialized
//            ois.resolveClass(ois.readClassDescriptor());

            Object deserialized = ois.readObject();
            System.out.println("Deserialized object: " + deserialized);
        } catch (ClassNotFoundException e) {
            throw new Exception("Class not found during deserialization", e);
        } catch (InvalidClassException e) {
            throw new Exception("Invalid class during deserialization", e);
        }
    }
}