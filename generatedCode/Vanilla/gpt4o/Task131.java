package Vanilla.openai;
import java.io.*;

public class Task131 {
    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteIn = new ByteArrayInputStream(data);
        ObjectInputStream in = new ObjectInputStream(byteIn);
        return in.readObject();
    }

    public static void main(String[] args) {
        try {
            // Test case 1: Serializing and deserializing a string
            ByteArrayOutputStream byteOut1 = new ByteArrayOutputStream();
            ObjectOutputStream out1 = new ObjectOutputStream(byteOut1);
            out1.writeObject("Hello World");
            byte[] data1 = byteOut1.toByteArray();
            System.out.println(deserialize(data1));

            // Test case 2: Serializing and deserializing an integer
            ByteArrayOutputStream byteOut2 = new ByteArrayOutputStream();
            ObjectOutputStream out2 = new ObjectOutputStream(byteOut2);
            out2.writeObject(12345);
            byte[] data2 = byteOut2.toByteArray();
            System.out.println(deserialize(data2));

            // Test case 3: Serializing and deserializing a double
            ByteArrayOutputStream byteOut3 = new ByteArrayOutputStream();
            ObjectOutputStream out3 = new ObjectOutputStream(byteOut3);
            out3.writeObject(3.14159);
            byte[] data3 = byteOut3.toByteArray();
            System.out.println(deserialize(data3));

            // Test case 4: Serializing and deserializing a boolean
            ByteArrayOutputStream byteOut4 = new ByteArrayOutputStream();
            ObjectOutputStream out4 = new ObjectOutputStream(byteOut4);
            out4.writeObject(true);
            byte[] data4 = byteOut4.toByteArray();
            System.out.println(deserialize(data4));

            // Test case 5: Serializing and deserializing a custom object
            ByteArrayOutputStream byteOut5 = new ByteArrayOutputStream();
            ObjectOutputStream out5 = new ObjectOutputStream(byteOut5);
            out5.writeObject(new java.util.Date());
            byte[] data5 = byteOut5.toByteArray();
            System.out.println(deserialize(data5));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}