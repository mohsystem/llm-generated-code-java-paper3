package Vanilla.claude;

import java.io.*;
import java.util.ArrayList;

class Task131 {
    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        // Use ByteArrayInputStream for deserialization
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        
        // Use ObjectInputStream with security checks
        ObjectInputStream ois = new ObjectInputStream(bis) {
            @Override
            protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
                // Whitelist allowed classes
                String className = desc.getName();
                if (className.equals("java.util.ArrayList") || 
                    className.equals("java.lang.String") ||
                    className.equals("java.lang.Integer")) {
                    return super.resolveClass(desc);
                }
                throw new SecurityException("Class " + className + " not allowed");
            }
        };
        
        // Deserialize object
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

    public static void main(String[] args) {
        try {
            // Test case 1: Serialize and deserialize ArrayList<String>
            ArrayList<String> list1 = new ArrayList<>();
            list1.add("test1");
            list1.add("test2");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(list1);
            Object result1 = deserialize(bos.toByteArray());
            System.out.println("Test 1: " + result1);

            // Test case 2: Serialize and deserialize String
            String str = "Hello World";
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(str);
            Object result2 = deserialize(bos.toByteArray());
            System.out.println("Test 2: " + result2);

            // Test case 3: Serialize and deserialize Integer
            Integer num = 42;
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(num);
            Object result3 = deserialize(bos.toByteArray());
            System.out.println("Test 3: " + result3);

            // Test case 4: Try to deserialize unauthorized class
            try {
                class Unauthorized implements Serializable {}
                Unauthorized unauth = new Unauthorized();
                bos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(bos);
                oos.writeObject(unauth);
                deserialize(bos.toByteArray());
            } catch (SecurityException e) {
                System.out.println("Test 4: Security check passed - unauthorized class blocked");
            }

            // Test case 5: Empty ArrayList
            ArrayList<String> emptyList = new ArrayList<>();
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(emptyList);
            Object result5 = deserialize(bos.toByteArray());
            System.out.println("Test 5: " + result5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
