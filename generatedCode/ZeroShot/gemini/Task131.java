package ZeroShot.gemini;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Base64;

class Task131 {

    public static Object deserialize(String base64Encoded) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(base64Encoded);
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return ois.readObject();
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String test1 = Base64.getEncoder().encodeToString("Hello".getBytes());
        System.out.println(deserialize(test1));


        String test2 = Base64.getEncoder().encodeToString("World".getBytes());
        System.out.println(deserialize(test2));


        String test3 = Base64.getEncoder().encodeToString("123".getBytes());
        System.out.println(deserialize(test3));



        String test4 = Base64.getEncoder().encodeToString("Test".getBytes());
        System.out.println(deserialize(test4));



        String test5 = Base64.getEncoder().encodeToString("Data".getBytes());
        System.out.println(deserialize(test5));

    }
}