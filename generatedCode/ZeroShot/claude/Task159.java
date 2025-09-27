package ZeroShot.claude;

public class Task159 {
    private byte[] buffer;
    private int bufferSize;
    
    public Task159(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Buffer size must be positive");
        }
        this.bufferSize = size;
        this.buffer = new byte[size];
    }
    
    public byte readFromBuffer(int index) {
        if (index < 0 || index >= bufferSize) {
            throw new IndexOutOfBoundsException("Invalid buffer index");
        }
        return buffer[index];
    }
    
    public void writeToBuffer(int index, byte value) {
        if (index < 0 || index >= bufferSize) {
            throw new IndexOutOfBoundsException("Invalid buffer index");
        }
        buffer[index] = value;
    }
    
    public static void main(String[] args) {
        // Test cases
        try {
            Task159 task = new Task159(10);
            
            // Test case 1: Write and read valid index
            task.writeToBuffer(0, (byte)65);
            System.out.println("Test 1: " + task.readFromBuffer(0)); // Should print 65
            
            // Test case 2: Read from valid index
            task.writeToBuffer(5, (byte)90);
            System.out.println("Test 2: " + task.readFromBuffer(5)); // Should print 90
            
            // Test case 3: Try negative index
            try {
                task.readFromBuffer(-1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Test 3: Caught expected exception for negative index");
            }
            
            // Test case 4: Try index beyond buffer size
            try {
                task.readFromBuffer(10);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Test 4: Caught expected exception for out of bounds index");
            }
            
            // Test case 5: Try creating buffer with negative size
            try {
                Task159 invalidTask = new Task159(-1);
            } catch (IllegalArgumentException e) {
                System.out.println("Test 5: Caught expected exception for negative buffer size");
            }
            
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
