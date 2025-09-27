package CoT.claude;

public class Task159 {
    private int[] buffer;
    private int size;
    
    public Task159(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Buffer size must be positive");
        }
        this.size = size;
        this.buffer = new int[size];
        // Initialize buffer with some data
        for(int i = 0; i < size; i++) {
            buffer[i] = i + 1;
        }
    }
    
    public int readFromBuffer(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return buffer[index];
    }
    
    public static void main(String[] args) {
        try {
            Task159 task = new Task159(10);
            
            // Test case 1: Valid index
            System.out.println("Test 1: " + task.readFromBuffer(5));
            
            // Test case 2: Another valid index
            System.out.println("Test 2: " + task.readFromBuffer(0));
            
            // Test case 3: Valid boundary index
            System.out.println("Test 3: " + task.readFromBuffer(9));
            
            // Test case 4: Invalid negative index
            System.out.println("Test 4: " + task.readFromBuffer(-1));
            
            // Test case 5: Invalid out of bounds index
            System.out.println("Test 5: " + task.readFromBuffer(10));
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
