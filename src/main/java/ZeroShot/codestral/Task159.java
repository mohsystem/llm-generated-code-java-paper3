package ZeroShot.codestral;
public class Task159 {
    private static byte[] buffer;

    public static void allocateBuffer(int size) {
        buffer = new byte[size];
    }

    public static byte readFromBuffer(int index) {
        if (index < 0 || index >= buffer.length) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return buffer[index];
    }

    public static void main(String[] args) {
        allocateBuffer(10);
        // Assume data is already filled into the buffer
        try {
            System.out.println(readFromBuffer(5));
            System.out.println(readFromBuffer(10)); // Throws exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}