package CoT.gemini;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Task95 {
    public static long getProcessorTimeInSeconds() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long nanoseconds = bean.getCurrentThreadCpuTime();
        return nanoseconds / 1000000000L;
    }

    public static void main(String[] args) {
        System.out.println("Test 1: " + getProcessorTimeInSeconds());
        System.out.println("Test 2: " + getProcessorTimeInSeconds());
        System.out.println("Test 3: " + getProcessorTimeInSeconds());
        System.out.println("Test 4: " + getProcessorTimeInSeconds());
        System.out.println("Test 5: " + getProcessorTimeInSeconds());
    }
}