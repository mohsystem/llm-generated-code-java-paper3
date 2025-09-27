package CoT.claude;

public class Task157 {
    public static int[] allocateAndDeallocate(int size) {
        if (size <= 0) {
            return null;
        }
        
        // Allocate memory
        int[] array = null;
        try {
            array = new int[size];
            // Initialize array
            for(int i = 0; i < size; i++) {
                array[i] = i + 1;
            }
        } catch (OutOfMemoryError e) {
            return null;
        }
        
        return array;
    }

    public static void main(String[] args) {
        // Test cases
        int[] testSizes = {5, 10, 0, -5, 3};
        
        for(int size : testSizes) {
            System.out.println("Test case with size: " + size);
            int[] result = allocateAndDeallocate(size);
            
            if(result != null) {
                System.out.print("Allocated array: ");
                for(int i = 0; i < result.length; i++) {
                    System.out.print(result[i] + " ");
                }
                System.out.println("\\nMemory deallocated automatically by JVM");
            } else {
                System.out.println("Failed to allocate memory or invalid size");
            }
            System.out.println();
        }
    }
}
