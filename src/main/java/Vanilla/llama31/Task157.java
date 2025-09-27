package Vanilla.llama31;
public class Task157 {
    public static void main(String[] args) {
        // Test cases
        for (int i = 0; i < 5; i++) {
            int size = i * 10 + 10;
            byte[] array = allocateMemory(size);
            System.out.println("Allocated " + size + " bytes");
            deallocateMemory(array);
            System.out.println("Deallocated " + size + " bytes");
        }
    }

    public static byte[] allocateMemory(int size) {
        return new byte[size];
    }

    public static void deallocateMemory(byte[] array) {
        // In Java, deallocation is handled by the garbage collector
        array = null;
    }
}