package Vanilla.codestral;
public class Task157 {
    public static void main(String[] args) {
        // Test cases
        allocateDeallocate(10);
        allocateDeallocate(20);
        allocateDeallocate(30);
        allocateDeallocate(40);
        allocateDeallocate(50);
    }

    public static void allocateDeallocate(int size) {
        // Allocate memory
        int[] arr = new int[size];
        System.out.println("Memory allocated for " + size + " integers.");

        // Deallocate memory
        arr = null;
        System.gc(); // Call garbage collector to deallocate memory
        System.out.println("Memory deallocated.");
    }
}