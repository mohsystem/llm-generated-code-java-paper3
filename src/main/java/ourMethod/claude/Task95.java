package ourMethod.claude;

public class Task95 {
    public static long getCurrentProcessorTime() {
        return System.nanoTime() / 1_000_000_000L; // Convert nanoseconds to seconds
    }
    
    public static void main(String[] args) {
        // Test cases
        for(int i = 0; i < 5; i++) {
            System.out.println("Current processor time in seconds: " + getCurrentProcessorTime());
            try {
                Thread.sleep(1000); // Wait 1 second between readings
            } catch(InterruptedException e) {
                System.err.println("Sleep interrupted");
            }
        }
    }
}
