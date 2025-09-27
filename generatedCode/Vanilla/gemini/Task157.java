package Vanilla.gemini;
class Task157 {
    public static void main(String[] args) {
        test(10);
        test(20);
        test(0);
        test(100);
        test(1);
    }
    
    public static void test(int size) {
        int[] arr = allocate(size);
        if (arr != null) {
            System.out.println("Allocated array of size " + size);
            deallocate(arr);
            System.out.println("Deallocated array of size " + size);
        }
    }
    
    public static int[] allocate(int size) {
        if (size <= 0) {
            return null;
        }
        return new int[size];
    }

    public static void deallocate(int[] arr) {
        // Java handles deallocation automatically with garbage collection.
        arr = null;
    }
}