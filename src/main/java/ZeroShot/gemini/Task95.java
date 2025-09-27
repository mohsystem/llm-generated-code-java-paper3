package ZeroShot.gemini;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

class Task95 {
    public static double getProcessorTimeInSeconds() {
        OperatingSystemMXBean osMBean = ManagementFactory.getOperatingSystemMXBean();
        //todo cannot find symbol method getProcessCpuTime()
        long processCpuTime = 1; //osMBean.getProcessCpuTime();
        return processCpuTime / 1.0e9;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Processor Time: " + getProcessorTimeInSeconds() + " seconds");
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}