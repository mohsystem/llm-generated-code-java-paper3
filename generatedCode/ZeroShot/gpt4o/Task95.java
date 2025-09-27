package ZeroShot.gpt4o;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Task95 {
    public static double getCurrentProcessorTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        if (bean.isCurrentThreadCpuTimeSupported()) {
            return bean.getCurrentThreadCpuTime() / 1_000_000_000.0;
        } else {
            return -1.0; // Indicate that CPU time is not supported
        }
    }

    public static void main(String[] args) {
        System.out.println("Test case 1: " + getCurrentProcessorTime());
        System.out.println("Test case 2: " + getCurrentProcessorTime());
        System.out.println("Test case 3: " + getCurrentProcessorTime());
        System.out.println("Test case 4: " + getCurrentProcessorTime());
        System.out.println("Test case 5: " + getCurrentProcessorTime());
    }
}