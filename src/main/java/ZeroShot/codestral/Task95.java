package ZeroShot.codestral;
public class Task95 {
    public static double getProcessorTime() {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e9;
    }

    public static void main(String[] args) {
        System.out.println("Processor time: " + getProcessorTime() + " seconds");
    }
}