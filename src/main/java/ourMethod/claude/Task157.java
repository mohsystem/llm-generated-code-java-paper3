package ourMethod.claude;

public class Task157 {
    public static int[] allocateAndDeallocate(int size) {
        if (size <= 0) {
            return null;
        }
        
        // Allocate memory
        int[] array = new int[size];
        
        // Initialize array
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        
        return array;
        // Java handles deallocation automatically through garbage collection
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: Size 5");
        int[] result1 = allocateAndDeallocate(5);
        if (result1 != null) {
            for (int i = 0; i < result1.length; i++) {
                System.out.print(result1[i] + " ");
            }
            System.out.println();
        }
        
        System.out.println("\\nTest Case 2: Size 0");
        int[] result2 = allocateAndDeallocate(0);
        System.out.println(result2 == null ? "Null returned" : "Array created");
        
        System.out.println("\\nTest Case 3: Size 10");
        int[] result3 = allocateAndDeallocate(10);
        if (result3 != null) {
            for (int i = 0; i < result3.length; i++) {
                System.out.print(result3[i] + " ");
            }
            System.out.println();
        }
        
        System.out.println("\\nTest Case 4: Size -5");
        int[] result4 = allocateAndDeallocate(-5);
        System.out.println(result4 == null ? "Null returned" : "Array created");
        
        System.out.println("\\nTest Case 5: Size 3");
        int[] result5 = allocateAndDeallocate(3);
        if (result5 != null) {
            for (int i = 0; i < result5.length; i++) {
                System.out.print(result5[i] + " ");
            }
            System.out.println();
        }
    }
}
