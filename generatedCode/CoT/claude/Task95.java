package CoT.claude;

public class Task95 {
    public static long getProcessorTime() {
        return System.nanoTime() / 1000000000; // Convert nanoseconds to seconds
    }
    
    public static void main(String[] args) {
        // Test cases
        for(int i=0; i<5; i++) {
            System.out.println("Test case " + (i+1) + ": " + getProcessorTime() + " seconds");
            try {
                Thread.sleep(1000); // Wait 1 second between tests
            } catch(InterruptedException e) {
                System.err.println("Thread interrupted");
            }
        }
    }
}
