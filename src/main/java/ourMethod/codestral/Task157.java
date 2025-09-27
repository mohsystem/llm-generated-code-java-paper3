package ourMethod.codestral;
public class Task157 {
    public static void main(String[] args) {
        // Allocate memory
        int[] array = new int[5];

        // Use the memory
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        // Deallocate memory
        array = null;
    }
}