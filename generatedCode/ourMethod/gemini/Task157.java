package ourMethod.gemini;
import java.util.Arrays;

class Task157 {

    public static int[] allocateAndDeallocate(int size) {
        if (size <= 0) {
            return new int[0]; // Return an empty array for invalid size
        }
        int[] arr = new int[size];
        // Initialize the array (optional, but good practice)
        Arrays.fill(arr, 0);

        //  Deallocate - eligible for garbage collection
        arr = null;
        return new int[0]; // Return an empty array to indicate deallocation
    }


    public static void main(String[] args) {
        // Test cases
        System.out.println(Arrays.toString(allocateAndDeallocate(5)));
        System.out.println(Arrays.toString(allocateAndDeallocate(10)));
        System.out.println(Arrays.toString(allocateAndDeallocate(0))); // Test with zero size
        System.out.println(Arrays.toString(allocateAndDeallocate(-1))); // Test with negative size
        System.out.println(Arrays.toString(allocateAndDeallocate(1))); // Test with size of 1
        
    }
}