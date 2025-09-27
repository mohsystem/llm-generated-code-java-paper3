package ourMethod.claude;

public class Task159 {
    private int[] buffer;
    
    public Task159(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Buffer size must be positive");
        }
        buffer = new int[size];
        // Initialize buffer with some values
        for (int i = 0; i < size; i++) {
            buffer[i] = i + 1;
        }
    }
    
    public int readFromBuffer(int index) {
        if (index < 0 || index >= buffer.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return buffer[index];
    }
    
    public static void main(String[] args) {
        // Test cases
        try {
            Task159 test = new Task159(10);
            
            // Test case 1: Valid index
            System.out.println("Test 1: " + test.readFromBuffer(5)); // Should print 6
            
            // Test case 2: Another valid index
            System.out.println("Test 2: " + test.readFromBuffer(0)); // Should print 1
            
            // Test case 3: Index at boundary
            System.out.println("Test 3: " + test.readFromBuffer(9)); // Should print 10
            
            // Test case 4: Invalid negative index
            System.out.println("Test 4: " + test.readFromBuffer(-1)); // Should throw exception
            
            // Test case 5: Invalid large index
            System.out.println("Test 5: " + test.readFromBuffer(10)); // Should throw exception
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
