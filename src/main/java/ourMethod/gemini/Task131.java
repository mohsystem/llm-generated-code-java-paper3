package ourMethod.gemini;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Base64;

class Task131 {

    public static Object deserialize(String serializedObject) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(serializedObject);
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return ois.readObject();
        }
    }



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Test cases
        String test1 = Base64.getEncoder().encodeToString("Test String".getBytes());
        String test2 = Base64.getEncoder().encodeToString(new byte[0]);

        class TestClass implements Serializable{
            public int value;
            public TestClass(int val){
                this.value = val;
            }
        }

        TestClass test3_obj = new TestClass(10);
        String test3 = "";
        try{
          java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
          java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
          oos.writeObject(test3_obj);
          test3 = Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(deserialize(test1));
        System.out.println(deserialize(test2).getClass().getSimpleName());

        TestClass tc = (TestClass)deserialize(test3);

        System.out.println(tc.value);


        String test4 = Base64.getEncoder().encodeToString("null".getBytes());
        System.out.println(deserialize(test4));


        String test5 = "invalid_input_string";
        try{
        System.out.println(deserialize(test5));
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid input");
        }



    }
}