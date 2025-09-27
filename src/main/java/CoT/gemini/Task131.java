package CoT.gemini;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
//import java.base64.Base64;
import java.util.Base64;

class Task131 {

    public static Object deserialize(String base64EncodedData) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(base64EncodedData);
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return ois.readObject();
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Test cases
        String serializedData1 = Base64.getEncoder().encodeToString("Hello, world!".getBytes());
        System.out.println(deserialize(serializedData1));

        String serializedData2 = Base64.getEncoder().encodeToString(new byte[0]); // Empty byte array
        System.out.println(deserialize(serializedData2));

        try {
            deserialize("invalid_base64_string"); 
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        try {
          deserialize(null);
        } catch (NullPointerException e) {
          System.out.println("Caught expected exception: " + e.getMessage());
        }


        MySerializableClass obj = new MySerializableClass(123, "test");
        String serializedData5 = Base64.getEncoder().encodeToString(serializeObject(obj));
        MySerializableClass deserializedObj = (MySerializableClass) deserialize(serializedData5);
        System.out.println(deserializedObj.getIntValue() + ", " + deserializedObj.getStringValue());


    }

    private static byte[] serializeObject(Serializable obj) throws IOException {
      try (java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
           java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos)) {
        oos.writeObject(obj);
        return baos.toByteArray();
      }
    }
}

class MySerializableClass implements Serializable {
    private int intValue;
    private String stringValue;

    public MySerializableClass(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}