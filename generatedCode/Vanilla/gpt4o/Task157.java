package Vanilla.openai;
public class Task157 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            memoryManagement();
        }
    }
    
    public static void memoryManagement() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        // Normally Java has automatic garbage collection, so explicit deallocation is not needed.
    }
}