package CoT.gemini;
class Task157 {
    public static void allocateAndDeallocate() {
        // Allocate memory for an integer
        int[] arr = new int[5]; 

        // Use the allocated memory (example)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2;
        }

        // Deallocate the memory explicitly in Java, it's handled by Garbage Collector
        arr = null; // Make the array eligible for garbage collection

        System.gc(); // Suggest garbage collection (not guaranteed to run immediately)
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            allocateAndDeallocate();
            System.out.println("Memory allocated and deallocated (Test case " + (i + 1) + ")");
        }
    }
}