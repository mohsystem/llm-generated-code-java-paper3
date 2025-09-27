package ZeroShot.claude;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Task131 {
    // Only allow deserialization of safe classes
    private static final List<String> WHITELIST_CLASSES = new ArrayList<String>() {{
        add("java.util.ArrayList");
        add("java.lang.String");
        add("java.lang.Integer");
    }};

    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Input data cannot be null or empty");
        }

        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bis) {
                 @Override
                 protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
                     String className = desc.getName();
                     if (!WHITELIST_CLASSES.contains(className)) {
                         throw new InvalidClassException("Unauthorized deserialization attempt", className);
                     }
                     return super.resolveClass(desc);
                 }
             }) {
            return ois.readObject();
        }
    }

    public static void main(String[] args) {
        try {
            // Test case 1: Serialize and deserialize a String
            String testStr = "Test String";
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(testStr);
            Object result1 = deserialize(bos.toByteArray());
            System.out.println("Test 1: " + (testStr.equals(result1) ? "Passed" : "Failed"));

            // Test case 2: Serialize and deserialize an ArrayList
            ArrayList<String> list = new ArrayList<>();
            list.add("item1");
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(list);
            Object result2 = deserialize(bos.toByteArray());
            System.out.println("Test 2: " + (result2 instanceof ArrayList ? "Passed" : "Failed"));

            // Test case 3: Try to deserialize null data
            try {
                deserialize(null);
                System.out.println("Test 3: Failed");
            } catch (IllegalArgumentException e) {
                System.out.println("Test 3: Passed");
            }

            // Test case 4: Try to deserialize empty data
            try {
                deserialize(new byte[0]);
                System.out.println("Test 4: Failed");
            } catch (IllegalArgumentException e) {
                System.out.println("Test 4: Passed");
            }

            // Test case 5: Try to deserialize invalid data
            try {
                deserialize(new byte[]{1, 2, 3});
                System.out.println("Test 5: Failed");
            } catch (IOException e) {
                System.out.println("Test 5: Passed");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
