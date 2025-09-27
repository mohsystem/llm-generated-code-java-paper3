package Vanilla.claude;

public class Task157 {
    private int[] array;
    
    public void allocateMemory(int size) {
        array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = i;
        }
    }
    
    public void deallocateMemory() {
        array = null; // Java garbage collector will handle deallocation
    }
    
    public static void main(String[] args) {
        Task157 obj = new Task157();
        
        // Test case 1
        obj.allocateMemory(5);
        obj.deallocateMemory();
        
        // Test case 2
        obj.allocateMemory(10);
        obj.deallocateMemory();
        
        // Test case 3
        obj.allocateMemory(0);
        obj.deallocateMemory();
        
        // Test case 4
        obj.allocateMemory(100);
        obj.deallocateMemory();
        
        // Test case 5
        obj.allocateMemory(1);
        obj.deallocateMemory();
    }
}
