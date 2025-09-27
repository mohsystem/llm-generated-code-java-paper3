package CoT.gpt4o;
public class Task157 {

    public static void main(String[] args) {
        // Test cases
        System.out.println("Allocated memory: " + allocateMemory(5));
        System.out.println("Allocated memory: " + allocateMemory(10));
        System.out.println("Allocated memory: " + allocateMemory(0));
        System.out.println("Allocated memory: " + allocateMemory(7));
        System.out.println("Allocated memory: " + allocateMemory(3));
    }

    public static int[] allocateMemory(int size) {
        if (size <= 0) {
            return new int[0];
        }
        int[] array = new int[size];
        // Deallocate memory is handled by Java's garbage collector
        return array;
    }
}