package ZeroShot.claude;

public class Task157 {
    private int[] dynamicArray;
    
    public void allocateMemory(int size) {
        try {
            dynamicArray = new int[size];
        } catch (OutOfMemoryError e) {
            System.out.println("Memory allocation failed");
            dynamicArray = null;
        }
    }
    
    public void deallocateMemory() {
        dynamicArray = null;
        System.gc(); // Request garbage collection
    }
    
    public static void main(String[] args) {
        Task157 task = new Task157();
        
        // Test case 1: Allocate and deallocate small array
        task.allocateMemory(10);
        task.deallocateMemory();
        
        // Test case 2: Allocate and deallocate medium array
        task.allocateMemory(1000);
        task.deallocateMemory();
        
        // Test case 3: Allocate and deallocate large array
        task.allocateMemory(100000);
        task.deallocateMemory();
        
        // Test case 4: Try to allocate very large array
        task.allocateMemory(Integer.MAX_VALUE);
        task.deallocateMemory();
        
        // Test case 5: Allocate zero size array
        task.allocateMemory(0);
        task.deallocateMemory();
    }
}
