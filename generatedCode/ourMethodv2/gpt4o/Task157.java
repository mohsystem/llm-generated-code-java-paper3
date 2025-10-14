package ourMethodv2.gpt4o;
public class Task157 {
    public static void main(String[] args) {
        // Test cases
        System.out.println(allocateMemory(5)); // Expected output: "Memory of size 5 allocated."
        System.out.println(allocateMemory(10)); // Expected output: "Memory of size 10 allocated."
        System.out.println(allocateMemory(0)); // Expected output: "Memory of size 0 allocated."
        System.out.println(allocateMemory(20)); // Expected output: "Memory of size 20 allocated."
        System.out.println(allocateMemory(-1)); // Expected output: "Invalid memory size."

    }

    public static String allocateMemory(int size) {
        if (size < 0) {
            return "Invalid memory size.";
        }
        
        int[] memory = new int[size];
        
        // Simulating memory allocation
        for (int i = 0; i < size; i++) {
            memory[i] = i;
        }
        
        // Simulating memory deallocation by nullifying reference
        memory = null;
        
        return "Memory of size " + size + " allocated.";
    }
}