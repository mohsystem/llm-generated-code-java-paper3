package ZeroShot.codestral;
public class Task157 {
    public static void main(String[] args) {
        // Allocate memory
        int[] arr = new int[5];
        // Use the memory
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        // Deallocate memory
        arr = null;
    }
}