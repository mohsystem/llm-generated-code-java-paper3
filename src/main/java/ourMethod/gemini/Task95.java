package ourMethod.gemini;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Task95 {

    public static double getProcessorTimeInSeconds() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long nanoseconds = bean.getCurrentThreadCpuTime();
        return (double) nanoseconds / 1_000_000_000.0;
    }

    public static void main(String[] args) {
        System.out.println("Test case 1: " + getProcessorTimeInSeconds());
        System.out.println("Test case 2: " + getProcessorTimeInSeconds());
        System.out.println("Test case 3: " + getProcessorTimeInSeconds());
        System.out.println("Test case 4: " + getProcessorTimeInSeconds());
        System.out.println("Test case 5: " + getProcessorTimeInSeconds());

    }
}