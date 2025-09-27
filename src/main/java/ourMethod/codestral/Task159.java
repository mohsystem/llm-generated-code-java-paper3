package ourMethod.codestral;
public class Task159 {
    private int[] buffer;

    public Task159(int size) {
        buffer = new int[size];
        // initialize buffer here
    }

    public int read(int index) {
        if (index < 0 || index >= buffer.length) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        return buffer[index];
    }

    public static void main(String[] args) {
        Task159 task = new Task159(10);
        // test cases
        try {
            System.out.println(task.read(5)); // should print the 5th element
            System.out.println(task.read(10)); // should throw IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}