package ZeroShot.claude;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Task95 {
    public static long getProcessorTime() {
        ThreadMXBean thread = ManagementFactory.getThreadMXBean();
        return thread.getCurrentThreadCpuTime() / 1_000_000_000; // Convert nanoseconds to seconds
    }

    public static void main(String[] args) {
        // Test cases
        for(int i = 0; i < 5; i++) {
            System.out.println("Test case " + (i+1) + ": " + getProcessorTime() + " seconds");
            // Do some computation to see time difference
            for(int j = 0; j < 1000000; j++) {
                Math.sqrt(j);
            }
        }
    }
}
