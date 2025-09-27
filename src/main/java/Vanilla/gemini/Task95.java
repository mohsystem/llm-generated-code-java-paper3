package Vanilla.gemini;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

class Task95 {
    public static double getProcessorTimeInSeconds() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long nanoseconds = bean.getCurrentThreadCpuTime();
        return (double) nanoseconds / 1_000_000_000.0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Processor time (seconds): " + getProcessorTimeInSeconds());
            try {
                Thread.sleep(1000); // Wait 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}