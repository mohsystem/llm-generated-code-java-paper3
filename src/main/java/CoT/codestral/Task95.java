package CoT.codestral;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Task95 {
    public static void main(String[] args) {
        System.out.println(getProcessCpuTime() / 1_000_000_000.0);
    }

    public static long getProcessCpuTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported() ? bean.getCurrentThreadCpuTime() : 0L;
    }
}