package ZeroShot.gemini;
class Task157 {
    public static void main(String[] args) {
        test(10);
        test(20);
        test(0);
        test(5);
        test(15);

    }

    static void test(int size) {
        int[] arr = allocateIntArray(size);
        if (arr != null) {
            System.out.println("Allocated array of size: " + size);
            deallocateIntArray(arr);
            System.out.println("Deallocated array of size: " + size);
        }
    }


    static int[] allocateIntArray(int size) {
        if (size <= 0) {
            System.err.println("Cannot allocate array of non-positive size.");
            return null;
        }

        try {
            return new int[size];
        } catch (OutOfMemoryError e) {
            System.err.println("Memory allocation failed: " + e.getMessage());
            return null;
        }
    }

    static void deallocateIntArray(int[] arr) {
        // In Java, garbage collection handles deallocation automatically.
        // We explicitly set the array reference to null to help the GC.
        arr = null;
    }

}