package CoT.llama31;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Task131 {
    public static class UserData implements Serializable {
        private String name;
        private int age;

        public UserData(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static UserData deserialize(byte[] data) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return (UserData) ois.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        // Test cases
        byte[] testData1 = serialize(new UserData("John Doe", 30));
        byte[] testData2 = serialize(new UserData("Jane Doe", 25));
        byte[] testData3 = serialize(new UserData("Bob Smith", 40));
        byte[] testData4 = serialize(new UserData("Alice Johnson", 35));
        byte[] testData5 = serialize(new UserData("Mike Brown", 20));

        UserData deserializedData1 = deserialize(testData1);
        UserData deserializedData2 = deserialize(testData2);
        UserData deserializedData3 = deserialize(testData3);
        UserData deserializedData4 = deserialize(testData4);
        UserData deserializedData5 = deserialize(testData5);

        System.out.println("Deserialized Data 1: " + deserializedData1.getName() + ", " + deserializedData1.getAge());
        System.out.println("Deserialized Data 2: " + deserializedData2.getName() + ", " + deserializedData2.getAge());
        System.out.println("Deserialized Data 3: " + deserializedData3.getName() + ", " + deserializedData3.getAge());
        System.out.println("Deserialized Data 4: " + deserializedData4.getName() + ", " + deserializedData4.getAge());
        System.out.println("Deserialized Data 5: " + deserializedData5.getName() + ", " + deserializedData5.getAge());
    }

    public static byte[] serialize(UserData data) throws Exception {
        try (java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
             java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(bos)) {
            oos.writeObject(data);
            return bos.toByteArray();
        }
    }
}