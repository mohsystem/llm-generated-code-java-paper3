package ZeroShot.gemini;
class Task159 {
    public static void main(String[] args) {
        test(5, new int[]{0, 1, 2, 3, 4});
        test(3, new int[]{5, 6, 7});
        test(0, new int[]{});
        test(1, new int[]{10});
        test(2, new int[]{-1, -2});

    }

    static void test(int size, int[] indices) {
        int[] buffer = allocateBuffer(size);
        for (int i = 0; i < size; i++) {
            buffer[i] = i * 10; 
        }

        for (int index : indices) {
            try {
                int value = readBuffer(buffer, size, index);
                System.out.println("Value at index " + index + ": " + value);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("----");


    }

    static int[] allocateBuffer(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Buffer size cannot be negative.");
        }
        return new int[size];
    }


    static int readBuffer(int[] buffer, int size, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for buffer of size " + size);
        }
        return buffer[index];
    }
}