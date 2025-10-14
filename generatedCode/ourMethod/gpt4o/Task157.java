package ourMethod.openai;
public class Task157 {
    public static void dynamicMemoryManagement(int size) {
        int[] array = null;
        try {
            array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = i;
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Error: Not enough memory available.");
        } finally {
            array = null; // Deallocate memory
        }
    }

    public static void main(String[] args) {
        dynamicMemoryManagement(5);
        dynamicMemoryManagement(10);
        dynamicMemoryManagement(0);
        dynamicMemoryManagement(-1);
        dynamicMemoryManagement(1000000);
    }
}