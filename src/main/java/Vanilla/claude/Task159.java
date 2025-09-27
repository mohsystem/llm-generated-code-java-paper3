package Vanilla.claude;

class Task159 {
    private byte[] buffer;

    public Task159(int size) {
        buffer = new byte[size];
        // Initialize buffer with some data
        for(int i = 0; i < size; i++) {
            buffer[i] = (byte)i;
        }
    }

    public byte readFromBuffer(int index) {
        if(index < 0 || index >= buffer.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return buffer[index];
    }

    public static void main(String[] args) {
        Task159 task = new Task159(100);
        
        // Test cases
        try {
            // Test case 1: Valid index
            System.out.println("Value at index 5: " + task.readFromBuffer(5));
            
            // Test case 2: Valid index
            System.out.println("Value at index 50: " + task.readFromBuffer(50));
            
            // Test case 3: Valid index
            System.out.println("Value at index 99: " + task.readFromBuffer(99));
            
            // Test case 4: Invalid index - negative
            System.out.println(task.readFromBuffer(-1));
            
            // Test case 5: Invalid index - out of bounds
            System.out.println(task.readFromBuffer(100));
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
