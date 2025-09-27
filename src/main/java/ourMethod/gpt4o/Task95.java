package ourMethod.gpt4o;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Task95 {
    public static double getCurrentProcessorTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported() ? bean.getCurrentThreadCpuTime() / 1_000_000_000.0 : 0.0;
    }

    public static void main(String[] args) {
        System.out.println("Processor time: " + getCurrentProcessorTime() + " seconds");
        System.out.println("Processor time: " + getCurrentProcessorTime() + " seconds");
        System.out.println("Processor time: " + getCurrentProcessorTime() + " seconds");
        System.out.println("Processor time: " + getCurrentProcessorTime() + " seconds");
        System.out.println("Processor time: " + getCurrentProcessorTime() + " seconds");
    }
}