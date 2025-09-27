package ourMethod.claude;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task131 {
    // Whitelist of allowed classes that can be deserialized
    private static final List<String> ALLOWED_CLASSES = new ArrayList<>();
    static {
        ALLOWED_CLASSES.add("java.util.ArrayList");
        ALLOWED_CLASSES.add("java.lang.String");
        ALLOWED_CLASSES.add("java.lang.Integer");
    }
    
    public static Object deserializeData(byte[] data) throws IOException, ClassNotFoundException {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Input data cannot be null or empty");
        }

        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bais) {
                 @Override
                 protected Class<?> resolveClass(ObjectStreamClass desc) 
                         throws IOException, ClassNotFoundException {
                     String className = desc.getName();
                     if (!ALLOWED_CLASSES.contains(className)) {
                         throw new InvalidClassException(
                             "Unauthorized deserialization attempt: " + className);
                     }
                     return super.resolveClass(desc);
                 }
             }) {
            return ois.readObject();
        }
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Test 1: Valid ArrayList<String>
            ArrayList<String> list = new ArrayList<>();
            list.add("test1");
            list.add("test2");
            byte[] serialized = serialize(list);
            Object deserialized = deserializeData(serialized);
            System.out.println("Test 1 (valid ArrayList): " + deserialized);

            // Test 2: Valid String
            String str = "Hello World";
            serialized = serialize(str);
            deserialized = deserializeData(serialized);
            System.out.println("Test 2 (valid String): " + deserialized);

            // Test 3: Null input
            try {
                deserializeData(null);
            } catch (IllegalArgumentException e) {
                System.out.println("Test 3 (null input): " + e.getMessage());
            }

            // Test 4: Empty input
            try {
                deserializeData(new byte[0]);
            } catch (IllegalArgumentException e) {
                System.out.println("Test 4 (empty input): " + e.getMessage());
            }

            // Test 5: Unauthorized class
            try {
                Runtime runtime = Runtime.getRuntime();
                serialized = serialize(runtime);
                deserializeData(serialized);
            } catch (InvalidClassException e) {
                System.out.println("Test 5 (unauthorized class): " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error in tests: " + e.getMessage());
        }
    }

    // Helper method to serialize objects for testing
    private static byte[] serialize(Object obj) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(obj);
            return baos.toByteArray();
        }
    }
}
