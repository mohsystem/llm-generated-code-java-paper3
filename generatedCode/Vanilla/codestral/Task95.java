package Vanilla.codestral;
public class Task95 {
    public static void main(String[] args) {
        System.out.println(getProcessorTime());
    }

    public static double getProcessorTime() {
        long startTime = System.nanoTime();
        // Perform some work to consume processor time
        for (int i = 0; i < 1000000; i++) {
            Math.sqrt(i);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e9;
    }
}