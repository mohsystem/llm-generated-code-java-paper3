package ZeroShot.gpt4o;
public class Task157 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int[] data = allocateMemory(10);
            for (int j = 0; j < data.length; j++) {
                data[j] = j + 1;
            }
            deallocateMemory(data);
        }
    }

    public static int[] allocateMemory(int size) {
        return new int[size];
    }

    public static void deallocateMemory(int[] data) {
        data = null;
    }
}