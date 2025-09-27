package Vanilla.llama31;
public class Task95 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // Your code here
        long endTime = System.nanoTime();
        double processorTime = (endTime - startTime) / 1e9;
        System.out.println("Processor time: " + processorTime + " seconds");
    }

    public static double getProcessorTime() {
        return System.nanoTime() / 1e9;
    }

    public static void mainWithTestCases() {
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            // Simulate some work
            for (int j = 0; j < 10000000; j++) {
                Math.random();
            }
            long endTime = System.nanoTime();
            double processorTime = (endTime - startTime) / 1e9;
            System.out.println("Test Case " + (i + 1) + ": Processor time: " + processorTime + " seconds");
        }
    }

    public static void main(String[] args) {
        mainWithTestCases();
    }
}