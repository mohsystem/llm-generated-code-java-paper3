package ourMethod.openai;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Base64;

public class Task131 {
    public static class SafeObject implements Serializable {
        private static final long serialVersionUID = 1L;
        private String data;

        public SafeObject(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }

    public static SafeObject deserializeObject(String base64String) {
        byte[] data = Base64.getDecoder().decode(base64String);
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            Object obj = ois.readObject();
            if (obj instanceof SafeObject) {
                return (SafeObject) obj;
            } else {
                throw new IllegalArgumentException("Deserialized object is not of type SafeObject");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String serializedSafeObject = "rO0ABXNyABBUYXNrMTMxJFN..."; // Example Base64 serialized SafeObject
        SafeObject obj = deserializeObject(serializedSafeObject);
        if (obj != null) {
            System.out.println(obj.getData());
        } else {
            System.out.println("Failed to deserialize object.");
        }
    }
}