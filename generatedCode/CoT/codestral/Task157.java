package CoT.codestral;
// Task157.java
public class Task157 {
    public static void main(String[] args) {
        // Allocate memory
        int[] numbers = new int[5];

        // Use the memory
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        // Deallocate memory
        numbers = null;
    }
}