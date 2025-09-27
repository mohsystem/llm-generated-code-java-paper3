package Vanilla.claude;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Task95 {
    public static double getProcessorTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.getCurrentThreadCpuTime() / 1.0e9; // Convert nanoseconds to seconds
    }

    public static void main(String[] args) {
        // Test cases
        for(int i = 0; i < 5; i++) {
            System.out.printf("Test case %d: %.6f seconds\\n", i+1, getProcessorTime());
            // Do some computation to show different times
            for(int j = 0; j < i*1000000; j++) {
                Math.sqrt(j);
            }
        }
    }
}
